package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button CButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CButton = findViewById(R.id.CButton);
        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login() {
        Intent welcome = new Intent(this, Welcom.class);
        startActivity(welcome);
        finish();
    }
}