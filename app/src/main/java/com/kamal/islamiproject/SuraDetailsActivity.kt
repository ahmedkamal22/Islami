package com.kamal.islamiproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.adapters.AyaAdapter
import kotlinx.android.synthetic.main.activity_sura_details.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var ayaAdapter: AyaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName: String = intent.getStringExtra(Constants.suraName) ?: ""
        val fileName: String = intent.getStringExtra(Constants.fileName) ?: ""
        sura_Title.setText(suraName)
        val ayat = readSuraContent(fileName)
        ayaAdapter = AyaAdapter(ayat)
        aya_recycler_view.adapter = ayaAdapter
    }

    private fun readSuraContent(fileName: String):List<String> {
        val suraLines = mutableListOf<String>()
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
//                Log.e("line", line)
                suraLines.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return suraLines
    }
}