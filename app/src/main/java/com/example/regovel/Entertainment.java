package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Entertainment extends AppCompatActivity {

    private ImageButton skyranchbutton,aquaplanetbutton,enchbutton;
    private ImageButton imageButton11;

    private ImageButton dashButton, profButton, backButton, contButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

        skyranchbutton =  findViewById(R.id.skybutton);
        aquaplanetbutton =  findViewById(R.id.aquabutton);
        enchbutton =  findViewById(R.id.enchantbutton);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, DevContact.class);
                startActivity(intent);
            }
        });


        skyranchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, Skyranch.class);
                startActivity(intent);
            }
        });
        aquaplanetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, AquaPlanet.class);
                startActivity(intent);
            }
        });
        enchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entertainment.this, EnchantedKingdom.class);
                startActivity(intent);
            }
        });

    }
}