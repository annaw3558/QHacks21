package com.example.qhacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button confirm;
    EditText newPasswordConfirm, newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        myDb = new DatabaseHelper(this);
        confirm = findViewById(R.id.confirm);
        newPassword = findViewById(R.id.newPassword);
        newPasswordConfirm = findViewById(R.id.newPasswordConfirm);


    }

    public void UpdatePassword(){
        confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (newPassword.getText().toString().equalsIgnoreCase(newPasswordConfirm.getText().toString())) {
                            boolean isUpdated = myDb.updatePassword(newPassword.getText().toString());
                            if (isUpdated == true)
                                Toast.makeText(ChangePasswordActivity.this, "Password Updated", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(ChangePasswordActivity.this, "Password Not Updated", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

        );
    }

    public void GoToLogin(View view){
        Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}