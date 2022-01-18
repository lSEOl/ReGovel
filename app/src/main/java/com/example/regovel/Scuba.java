package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Scuba extends AppCompatActivity {
    private ImageButton tubbabutton,anibutton;

    private ImageButton dashButton, profButton, backButton, contButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scuba);

        tubbabutton =  findViewById(R.id.tubbatahabutton);
        anibutton =  findViewById(R.id.anilaobutton);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, DevContact.class);
                startActivity(intent);
            }
        });

        tubbabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, Tubbataha.class);
                startActivity(intent);
            }
        });
        anibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scuba.this, Anilao.class);
                startActivity(intent);
            }
        });
    }
}