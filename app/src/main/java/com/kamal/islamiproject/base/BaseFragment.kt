package com.example.islami.base

import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseFragment:Fragment(){

    fun makeToast(message:String)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
    fun showDialig(title:String?=null,message:String?=null,posActionName:String?=null,
                   posAction:DialogInterface.OnClickListener?=null,negActionName:String?=null,
                   negAction:DialogInterface.OnClickListener?=null,isCancallable:Boolean = true)
    {
        val dialog = AlertDialog.Builder(context!!)
        dialog.setCancelable(isCancallable)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setPositiveButton(posActionName,posAction)
        dialog.setNegativeButton(negActionName,negAction)
                .show()
    }
}