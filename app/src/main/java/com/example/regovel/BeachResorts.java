package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BeachResorts extends AppCompatActivity {

    private ImageButton boracaybutton,elnibutton,eskabutton,amanbutton;
    private ImageButton imageButton11;

    private ImageButton dashButton, profButton, backButton, contButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_resorts);

        boracaybutton =  findViewById(R.id.borabutton);
        elnibutton =  findViewById(R.id.elnidobutton);
        eskabutton =  findViewById(R.id.eskayabutton);
        amanbutton =  findViewById(R.id.amanpulobutton);

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, DevContact.class);
                startActivity(intent);
            }
        });


        boracaybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Boracay.class);
                startActivity(intent);
            }
        });
        eskabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Eskaya.class);
                startActivity(intent);
            }
        });
        amanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Amanpulo.class);
                startActivity(intent);
            }
        });
        elnibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeachResorts.this, Elnido.class);
                startActivity(intent);
            }
        });



    }
}