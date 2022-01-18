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

public class DevContact extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private static final int REQUEST_CALL1 = 1;
    private static final int REQUEST_CALL2 = 1;
    private static final int REQUEST_CALL3 = 1;

    private ImageButton dashButton, profButton, backButton, contButton;;
    private ImageButton call,call1,call2,call3;
    private EditText phone,phone1,phone2,phone3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_contact);

        call = findViewById(R.id.contact1);
        call1 = findViewById(R.id.contact2);
        call2 = findViewById(R.id.contact3);
        call3 = findViewById(R.id.contact4);
        phone = findViewById(R.id.number);
        phone1 = findViewById(R.id.number4);
        phone2 = findViewById(R.id.number2);
        phone3 = findViewById(R.id.number3);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makePhoneCall();

            }
        });
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makePhoneCall1();

            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makePhoneCall2();

            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makePhoneCall3();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevContact.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevContact.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevContact.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevContact.this, DevContact.class);
                startActivity(intent);
            }
        });
    }
    private void makePhoneCall(){
        String phoneNumber = phone.getText().toString();
        if (phoneNumber.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(DevContact.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DevContact.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(DevContact.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    private void makePhoneCall1(){
        String phoneNumber = phone1.getText().toString();
        if (phoneNumber.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(DevContact.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DevContact.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL1);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(DevContact.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    private void makePhoneCall2(){
        String phoneNumber = phone2.getText().toString();
        if (phoneNumber.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(DevContact.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DevContact.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL2);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(DevContact.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    private void makePhoneCall3(){
        String phoneNumber = phone3.getText().toString();
        if (phoneNumber.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(DevContact.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DevContact.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL3);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(DevContact.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
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
       else if (requestCode == REQUEST_CALL1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                makePhoneCall1();

            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
       else if (requestCode == REQUEST_CALL2) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                makePhoneCall2();

            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
       else if (requestCode == REQUEST_CALL3) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                makePhoneCall3();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}