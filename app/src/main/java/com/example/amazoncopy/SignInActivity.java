package com.example.amazoncopy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button skipinButton = findViewById(R.id.button_skip_sign_in);

        skipinButton.setOnClickListener(v->{
            Intent intent=new Intent(SignInActivity.this, ProductsActivity.class);
            startActivity(intent);
        });
    }
}
