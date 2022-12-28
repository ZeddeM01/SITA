package com.develovit.sita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class testing extends AppCompatActivity {

    private static final String TAG = "Notification-Debug";
    private static final String CHANNEL_ID = "test_channel" ;
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        // 1. Ambil notification manager
        notificationManager = NotificationManagerCompat.from(this);
        // 2b. Buat channel notifikasi
        createNotificationChannel();
        buttonShow = findViewById(R.id.ButtonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(testing.this, Home.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(testing.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                // 3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(testing.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.warning)
                        .setContentTitle("Notifikasi ke activity Home")
                        .setContentText("Klik notifikasi ini untuk pergi ke activity Home")
//                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.warning, "PERGI", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                // 4. Buat objek notifikasi
                Notification notification = builder.build();
                // 5. Tampilkan notifikasi
                notificationManager.notify(101, notification);
            }
        });

        // Kode token Firebase
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(testing.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // 2a. Buat channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel Contoh", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Ini hanya channel untuk contoh notifikasi");
            notificationManager.createNotificationChannel(channel);
        }
    }
}