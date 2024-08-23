package com.moin.qrcodeffiandroid;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.konylabs.vm.Function;

import java.io.ByteArrayOutputStream;

public class QRGenActivity extends AppCompatActivity {

    public static Function qrGenCallBack = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.qrcode_activity);
        String input = getIntent().getStringExtra("input");
            generateQRCode(input);



    }

    public void generateQRCode(String input){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap;
            if(input != null && !input.isEmpty()){

                bitmap = barcodeEncoder.encodeBitmap(input, BarcodeFormat.QR_CODE, 400, 400);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream .toByteArray();
                String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
                String returndata[] = new String[1];
                returndata[0] = encoded;
                try {
                    qrGenCallBack.execute(returndata);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
            else{
                Toast.makeText(this, "Text Field is empty, please enter text", Toast.LENGTH_LONG).show();
                finish();
            }
        } catch(Exception e) {

        }
    }

}