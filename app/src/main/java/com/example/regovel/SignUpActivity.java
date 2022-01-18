package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    Button button,regButton;
    private TextInputEditText textInputEditText;
    TextInputLayout regEmail, regPassword, regPhone , regName, regUserLogin;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditText = (TextInputEditText) findViewById(R.id.inputusername);

        button = (Button) findViewById(R.id.backtologin);
        regButton = (Button) findViewById(R.id.created);

        regUserLogin = findViewById(R.id.reg_Username);
        regName = findViewById(R.id.reg_Name);
        regEmail = findViewById(R.id.reg_Email);
        regPassword = findViewById(R.id.reg_Password);
        regPhone = findViewById(R.id.reg_Phone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, Login.class);
                startActivity(intent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode =  FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //Get all the values
                String username = regUserLogin.getEditText().getText().toString();
                String name = regName.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phone = regPhone.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(username,name,email,password,phone);

                reference.child(username).setValue(helperClass);

                Intent intent = new Intent(SignUpActivity.this, Login.class);
                startActivity(intent);
            }
        });


    }
}