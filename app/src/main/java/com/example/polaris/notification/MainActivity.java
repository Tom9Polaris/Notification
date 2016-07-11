package com.example.polaris.notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.send_notice:
                    NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    Notification builder = new Notification.Builder(this).
                            setContentTitle("欧洲杯").
                            setContentText("葡法决赛，葡萄牙夺冠").
                            setSmallIcon(R.drawable.iclauncherweb).
                            setContentInfo("葡萄牙首次夺冠").
                            setWhen(System.currentTimeMillis()).build();
                    manager.notify(1,builder);    //Post a notification to be shown in the status bar.
                    break;
                default:
                    break;
            }
        }

}
