package com.example.qhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText enterNameText, enterEmailText, enterBirthdateText, enterHealthCardText, enterPinText;
    Button register, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        enterNameText = findViewById(R.id.enterNameText);
        enterEmailText = findViewById(R.id.enterEmailText);
        enterBirthdateText = findViewById(R.id.enterBirthdateText);
        enterHealthCardText = findViewById(R.id.enterHealthCardText);
        enterPinText = findViewById(R.id.enterPinText);
        register = findViewById(R.id.register);

        AddUser();
    }

    public void AddUser(){
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(enterNameText.getText().toString(),
                                enterEmailText.getText().toString(),
                                enterBirthdateText.getText().toString(),
                                enterHealthCardText.getText().toString(),
                                "0",
                                "None",
                                enterPinText.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(RegisterActivity.this, "User Registered", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegisterActivity.this, "User Not Registered", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}