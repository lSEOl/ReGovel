package com.example.regovel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button btn_login, btn_signup;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout userlogin,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //Hooks
        btn_signup = findViewById(R.id.createacc);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        userlogin = findViewById(R.id.user_login);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.login_btn);



        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUpActivity.class);

                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(sloganText, "slogan_text");
                pairs[3] = new Pair<View, String>(userlogin, "username_tran");
                pairs[4] = new Pair<View, String>(password, "password_tran");
                pairs[5] = new Pair<View, String>(btn_login, "login_tran");
                pairs[6] = new Pair<View, String>(btn_signup, "signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            }

        });

    }

    private Boolean validateUsername() {
        String val = userlogin.getEditText().getText().toString();
        if (val.isEmpty()) {
            userlogin.setError("Field cannot be empty");
            return false;
        } else {
            userlogin.setError(null);
            userlogin.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
            //Validate Login Info
            if (!validateUsername() | !validatePassword()) {
                return;
            } else {
                isUser();
            }
        }

    private void isUser() {

        final String userEnteredlogin = userlogin.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredlogin);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    userlogin.setError(null);
                    userlogin.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredlogin).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {

                        userlogin.setError(null);
                        userlogin.setErrorEnabled(false);

                        String usernameFromDB = dataSnapshot.child(userEnteredlogin).child("username").getValue(String.class);
                        String nameFromDB = dataSnapshot.child(userEnteredlogin).child("name").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredlogin).child("email").getValue(String.class);
                        String phoneFromDB = dataSnapshot.child(userEnteredlogin).child("phone").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),  Profile.class);

                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone", phoneFromDB);
                        intent.putExtra("password", passwordFromDB);

                        startActivity(intent);

                    } else {

                        password.setError("Wrong Password");
                        password.requestFocus();

                    }
                } else {
                    userlogin.setError("No such UserLogin exist");
                    password.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }



}



