package com.example.islami.fragments

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.adapters.RadiosAdapter
import com.example.islami.base.BaseFragment
import com.kamal.islamiproject.R
import com.kamal.islamiproject.api.*
import kotlinx.android.synthetic.main.fragment_mb3_quran.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Url

class Mb3QuranFragment : BaseFragment() {
    lateinit var radiosAdapter: RadiosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mb3_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        ApiManager.getApis().getRadiosChannels().enqueue(object :Callback<RadioResponse>{
            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                showDialig(title = "Error 404",message = "Network Issue ${t.localizedMessage}",
                posActionName = "Retry",posAction = DialogInterface.OnClickListener { dialog, which ->
                    call.enqueue(this)
                    dialog.dismiss()
                })
            }

            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                progress.visibility = View.GONE
                if(response.isSuccessful)
                {
                    val data = response.body()
                    radiosAdapter.changeData(data?.radios)
                    Log.e("data",data.toString())
                }
            }
        })
    }

     fun setRecyclerView() {
        radiosAdapter = RadiosAdapter(null)
         radios_recycler_view.adapter = radiosAdapter
        radiosAdapter.onPlayClickListener = object :RadiosAdapter.onItemClickListener
        {
            override fun onItemClick(position: Int, radiosChannels: RadiosChannel) {
                playRadio(radiosChannels.radioUrl?:"")
            }
        }
        radiosAdapter.onStopClickListener = object :RadiosAdapter.onItemClickListener
        {
            override fun onItemClick(position: Int, radiosChannels: RadiosChannel) {
                stopRadio()
            }
        }
    }

    val mediaPlayer = MediaPlayer()
     fun playRadio(url:String) {
        stopRadio()
        mediaPlayer.setDataSource(activity!!,Uri.parse(url))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener {
            it.start()
        }
    }
     fun stopRadio() {
        if(mediaPlayer.isPlaying)
        {
            mediaPlayer.stop()
        }
        mediaPlayer.reset()
    }
}