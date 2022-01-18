package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {

    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;
    private ImageButton boracaybutton,skyranchbutton,aquaplanetbutton,banauebutton,mallofasiabutton;

    private ImageButton dashButton, profButton, backButton, contButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        imageButton1 =  findViewById(R.id.hikingbutton);
        imageButton2 =  findViewById(R.id.resortbutton);
        imageButton3 =  findViewById(R.id.scubabutton);
        imageButton4 =  findViewById(R.id.entertainmentbutton);
        imageButton5 =  findViewById(R.id.mallbutton);

        boracaybutton =  findViewById(R.id.borabutton);
        skyranchbutton =  findViewById(R.id.skybutton);
        aquaplanetbutton =  findViewById(R.id.aquabutton);
        banauebutton =  findViewById(R.id.banabutton);
        mallofasiabutton =  findViewById(R.id.masiabutton);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, DevContact.class);
                startActivity(intent);
            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, HikingTrails.class);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, BeachResorts.class);
                startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Scuba.class);
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Entertainment.class);
                startActivity(intent);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Malls.class);
                startActivity(intent);
            }
        });

        boracaybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Boracay.class);
                startActivity(intent);
            }
        });
        skyranchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Skyranch.class);
                startActivity(intent);
            }
        });
        aquaplanetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, AquaPlanet.class);
                startActivity(intent);
            }
        });
        banauebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Banaue.class);
                startActivity(intent);
            }
        });
        mallofasiabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, MallofAsia.class);
                startActivity(intent);
            }
        });

    }
}