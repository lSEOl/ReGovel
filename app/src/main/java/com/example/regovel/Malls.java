package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Malls extends AppCompatActivity {
    private ImageButton mallofasiabutton;

    private ImageButton dashButton, profButton, backButton, contButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);

        mallofasiabutton =  findViewById(R.id.masiabutton);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malls.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malls.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malls.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malls.this, DevContact.class);
                startActivity(intent);
            }
        });

        mallofasiabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Malls.this, MallofAsia.class);
                startActivity(intent);
            }
        });
    }
}