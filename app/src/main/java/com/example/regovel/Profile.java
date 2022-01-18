package com.example.regovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class Profile extends AppCompatActivity {

    TextInputLayout pEmail, pPassword, pPhone , pUser;
    TextView pUsername;
    Button bUpdate, bDeteleAcc;
    private ImageButton dashButton, profButton, backButton, contButton;;

    String user_login, user_name, user_email, user_phoneNo, user_password;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        pUsername = findViewById(R.id.login_user_name);
        pEmail = findViewById(R.id.profile_Email);
        pPhone = findViewById(R.id.profile_Phone);
        pUser = findViewById(R.id.profile_Username);
        pPassword = findViewById(R.id.profile_Password);

        bUpdate = findViewById(R.id.btn_update);
        bDeteleAcc = findViewById(R.id.btn_deleteAcc);

        showAllUserData();

        backButton = findViewById(R.id.backbutton);
        profButton = findViewById(R.id.tourbutton);
        dashButton = findViewById(R.id.homebutton);
        contButton = findViewById(R.id.contactbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
            }
        });
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Profile.this, Profile.class);
                startActivity(intent);
            }
        });
        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, DashBoard.class);
                startActivity(intent);
            }
        });
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, DevContact.class);
                startActivity(intent);
            }
        });

    }
    private void showAllUserData() {
        Intent intent = getIntent();

         user_login = intent.getStringExtra("username");
         user_name = intent.getStringExtra("name");
         user_email = intent.getStringExtra("email");
         user_phoneNo = intent.getStringExtra("phone");
         user_password = intent.getStringExtra("password");

        pUsername.setText(user_login);
        pUser.getEditText().setText(user_name);
        pEmail.getEditText().setText(user_email);
        pPhone.getEditText().setText(user_phoneNo);
        pPassword.getEditText().setText(user_password);
    }

    public void update(View view){

        if(isNameChanged() && isPasswordChanged() && isEmailChanged() && isPhoneChanged()){
            Toast.makeText(this,"All data has been updated", Toast.LENGTH_LONG).show();

        }else if(isNameChanged() && isPasswordChanged() && isEmailChanged()){


        }else if(isPasswordChanged() && isEmailChanged() && isPhoneChanged()){


        }else if(isNameChanged() && isEmailChanged() && isPhoneChanged()){


        }else if(isNameChanged() && isPasswordChanged() && isPhoneChanged()){


        }else if(isNameChanged() && isPasswordChanged()){


        }else if(isNameChanged() && isEmailChanged()){


        }else if(isNameChanged() && isPhoneChanged()){


        }else if(isPasswordChanged() && isEmailChanged()){


        }else if(isPasswordChanged() && isPhoneChanged()){


        }else if(isEmailChanged() && isPhoneChanged()){


        }else if(isPhoneChanged() && isEmailChanged()){

        }

    }

    private boolean isEmailChanged() {
        if(!user_email.equals(pEmail.getEditText().getText().toString())){
            reference.child(user_login).child("email").setValue(pEmail.getEditText().getText().toString());
            user_email = pEmail.getEditText().getText().toString();
            Toast.makeText(this,"Email has been updated", Toast.LENGTH_LONG).show();
            return true;
        }else{
            return false;
        }
    }
    private boolean isPhoneChanged() {
        if(!user_phoneNo.equals(pPhone.getEditText().getText().toString())) {
            reference.child(user_login).child("phone").setValue(pPhone.getEditText().getText().toString());
            user_phoneNo = pPhone.getEditText().getText().toString();
            Toast.makeText(this,"Phone no. has been updated", Toast.LENGTH_LONG).show();
            return true;
        }else{
            return false;
        }
    }

    private boolean isNameChanged() {
        if(!user_name.equals(pUser.getEditText().getText().toString())){
            reference.child(user_login).child("name").setValue(pUser.getEditText().getText().toString());
            user_name = pUser.getEditText().getText().toString();
            Toast.makeText(this,"Name has been updated", Toast.LENGTH_LONG).show();
            return true;
        }else{
            return false;
        }
    }

    private boolean isPasswordChanged() {
        if(!user_password.equals(pPassword.getEditText().getText().toString())) {
            reference.child(user_login).child("password").setValue(pPassword.getEditText().getText().toString());
            user_password = pPassword.getEditText().getText().toString();
            Toast.makeText(this,"Password has been updated", Toast.LENGTH_LONG).show();
            return true;
        }else{
            return false;
        }
    }

    public void delete(View view){

        if(isAccountDeleted()){
            Toast.makeText(this,"The Account has been removed", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this,"The Account cant be removed", Toast.LENGTH_LONG).show();

    }

    private boolean isAccountDeleted() {
        reference.child(user_login).removeValue();
        Intent intent = new Intent(getApplicationContext(),  Login.class);
        startActivity(intent);
        return true;
    }



}