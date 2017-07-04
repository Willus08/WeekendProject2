package com.example.android.weekendproject2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class SMS extends AppCompatActivity {
    private EditText mesg;
    private EditText number;
    int My_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        mesg =(EditText) findViewById(R.id.etText);
        number = (EditText) findViewById(R.id.etNumber);
    }

    public void send(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},My_REQUEST);
        }
        else {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number.getText().toString(), null, mesg.getText().toString(), null, null);
        }
    }
}
// 9517046773