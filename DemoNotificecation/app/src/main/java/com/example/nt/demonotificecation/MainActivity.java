package com.example.nt.demonotificecation;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               notificeManager();
           }
       });
    }
    private void notificeManager(){
        Intent intent = new Intent(getApplicationContext(),ShowNotificationDetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                MainActivity.this,
                10,
                intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification myNotification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Exercise of Notification!")
                .setContentText("http://android-er.blogspot.com/")
                .setTicker("Notification!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(false)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        notificationManager.notify(100,myNotification);
    }
}
