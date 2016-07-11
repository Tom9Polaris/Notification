package com.example.polaris.notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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
                    Intent intent = new Intent(this,NotificationActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                    Notification builder = new Notification.Builder(this).
                            setContentTitle("欧洲杯").
                            setContentText("葡法决赛，葡萄牙夺冠").
                            setSmallIcon(R.drawable.iclauncherweb).
                            setContentInfo("葡萄牙首次夺冠").
                            setWhen(System.currentTimeMillis()).
                            setContentIntent(pi).     //添加具体信息
                            build();
                    builder.flags |= Notification.FLAG_AUTO_CANCEL;    //运行后消失

                    manager.notify(1,builder);    //Post a notification to be shown in the status bar.
                    break;
                default:
                    break;
            }
        }

}
