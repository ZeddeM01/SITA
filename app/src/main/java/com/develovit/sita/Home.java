package com.develovit.sita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class Home extends AppCompatActivity {
    private static final String TAG = "MainActivity-Debug";


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                        Toast.makeText(Home.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void logoutClick(View view) {
        Intent detailIntent = new Intent (this,Login.class);
        startActivity(detailIntent);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        //Register for menu item click listener
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return onPopupMenuClick (menuItem);
            }

            private boolean onPopupMenuClick(MenuItem menuItem) {
                return onPopupMenuClick (menuItem);
            }

        });
        popupMenu.show();
    }




    public void seminar0(View view) {
        Intent seminar0= new Intent (this, Seminarlist.class);
        startActivity(seminar0);
    }

    public void sidang0(View view) {
        Intent sidang0= new Intent (this, Sidanglist.class);
        startActivity(sidang0);
    }

    public void Mhs0(View view) {
        Intent Mhs0= new Intent (this, MainActivity.class);
        startActivity(Mhs0);
    }

    public void ta0(View view) {
        Intent ta0= new Intent (this, JadwalSidang.class);
        startActivity(ta0);
    }

}