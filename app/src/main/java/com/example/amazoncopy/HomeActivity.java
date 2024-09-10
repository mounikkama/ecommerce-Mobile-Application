package com.example.amazoncopy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;


public class HomeActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_home);

        Button signInButton = findViewById(R.id.startbutton);

        signInButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
            startActivity(intent);
        });

    }

}
