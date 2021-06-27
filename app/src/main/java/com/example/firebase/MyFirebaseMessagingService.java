package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull @NotNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        getnotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void  getnotification(String title,String getmsg){
       /*
        ******* Notification Builder *******
        */

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"msg")
                .setSmallIcon(R.drawable.notify)
                .setContentTitle(title)
                .setContentText(getmsg)
                .setAutoCancel(true);

        /*
        *******Notification Manager*******
         */

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(101,builder.build());


    }
}
