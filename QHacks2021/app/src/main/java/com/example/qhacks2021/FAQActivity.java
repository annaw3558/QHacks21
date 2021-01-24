package com.example.qhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FAQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
    }

    public void ReturnHome(View view){
        Intent intent = new Intent(FAQActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}