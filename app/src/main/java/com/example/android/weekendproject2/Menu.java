package com.example.android.weekendproject2;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Menu extends AppCompatActivity  implements Stop_go.OnFragmentInteractionListener,Counter.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void showDefaultdialog(View view) {
        AlertDialog dialog = new AlertDialog.Builder(Menu.this).create();

        dialog.setTitle("Doom");
        dialog.setMessage("Your phone is doomed to be replased in X years");
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok...", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void showCustomdialog(View view) {
//


        Dialog dialog = new Dialog(this);
        dialog.setTitle("Hi");
        dialog.setContentView(R.layout.activity_custom_dialog);

        dialog.show();

    }


    public void maybe(View view) {
    }

    public void counters(View view) {
        Stop_go fragment = new Stop_go();
        getSupportFragmentManager().beginTransaction().add(R.id.flFirstFragment,fragment,"STOP_GO").commit();
        Counter counter = new Counter();
        getSupportFragmentManager().beginTransaction().add(R.id.SecondFragment,counter,"COUNTER").commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static  void StartThread()
    {
        ThreadedClass threadedClass = new ThreadedClass(true);
        threadedClass.run();
    }

    @Override
    public void onFragmentInteraction(String string) {

    }

    public void goToReader(View view) {
        Intent intent = new Intent(Menu.this, PdfReader.class);
        startActivity(intent);
    }

    public void goToSMS(View view) {
        Intent intent = new Intent(Menu.this,SMS.class);
        startActivity(intent);
    }

    public void notification(View view) {

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,SMS.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int) System.currentTimeMillis(),intent,0);


        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.background2)
                .setContentTitle("Hi")
                .setContentText("You have been Notified")
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(0,notification);
    }
}
