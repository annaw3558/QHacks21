package com.example.qhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void ShowQRCode(View view){
        Intent intent = new Intent(HomeActivity.this, QrcodeActivity.class);
        startActivity(intent);
    }
    public void ShowFAQ(View view){
        Intent intent = new Intent(HomeActivity.this, FAQActivity.class);
        startActivity(intent);
    }
}