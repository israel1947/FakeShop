package com.example.fakestore

import android.app.Activity
import android.app.AlertDialog

class LoadingDialog(val lActivity: Activity) {
    private lateinit var isDialog:AlertDialog;

    fun startLoading(msg:String){
        val inflater = lActivity.layoutInflater;
        val dialogView = inflater.inflate(R.layout.loading_spiner,null);

        val builder =  AlertDialog.Builder(lActivity, R.style.CustomProgressBar);
        builder.setView(dialogView);
        builder.setTitle(msg);
        builder.setCancelable(false);
        isDialog = builder.create();
        isDialog.show();
    }

    fun isDismiss(){
        isDialog.dismiss();
    }
}