package com.example.regovel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Tubbataha extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;

    private ImageButton call;
    private EditText phone;

    private ImageButton dashButton, profButton, backButton, contButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubbataha);

        call = findViewById(R.id.Call);
        phone = findViewById(R.id.number);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tubbataha.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tubbataha.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tubbataha.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tubbataha.this, DevContact.class);
                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makePhoneCall();

            }
        });
    }
    private void makePhoneCall(){
        String phoneNumber = phone.getText().toString();
        if (phoneNumber.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Tubbataha.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Tubbataha.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(Tubbataha.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}