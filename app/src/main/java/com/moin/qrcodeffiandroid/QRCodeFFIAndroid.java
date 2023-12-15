package com.moin.qrcodeffiandroid;

import android.content.Context;
import android.content.Intent;

import com.konylabs.android.KonyMain;
import com.konylabs.vm.Function;



public class QRCodeFFIAndroid {
    private static Context context = (Context)KonyMain.getActivityContext();
    public static void scan(Function callback) {
        QRScanActivity.qrScanCallBack = callback;
        context.startActivity(new Intent(context, QRScanActivity.class));

        }
    public static void generate(Function callback,String input) {
        QRGenActivity.qrGenCallBack = callback;
        Intent intent = new Intent(context, QRGenActivity.class);
        intent.putExtra("input",input);
        context.startActivity(intent);

    }
    }