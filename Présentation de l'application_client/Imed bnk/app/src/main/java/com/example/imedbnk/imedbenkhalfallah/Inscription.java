package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Inscription extends AppCompatActivity {

    private EditText IUsername, IEmail, IPhoneNumber, IUserPassword;
    private Button IButton;
    private TextView ITextView;
    private String Username, UserPassword, Email, PhoneNumber;
    private String URL = "http://192.168.1.8/server/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Username = UserPassword = Email = PhoneNumber = "";
        IUsername = findViewById(R.id.IUsername);
        IEmail = findViewById(R.id.IEmail);
        IPhoneNumber = findViewById(R.id.IPhoneNumber);
        IUserPassword = findViewById(R.id.IUserPassword);
        IButton = findViewById(R.id.IButton);
        ITextView = findViewById(R.id.ITextView);

        IButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


        ITextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void save() {
        Username = IUsername.getText().toString().trim();
        Email = IEmail.getText().toString().trim();
        PhoneNumber = IPhoneNumber.getText().toString().trim();
        UserPassword = IUserPassword.getText().toString().trim();
        if (!Username.equals("") && !Email.equals("") && !PhoneNumber.equals("") && !UserPassword.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        ITextView.setText("Successfully registered.");
                        IButton.setClickable(false);
                    } else if (response.equals("failure")) {
                        ITextView.setText("Something went wrong!");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("Username", Username);
                    data.put("Email", Email);
                    data.put("PhoneNumber", PhoneNumber);
                    data.put("UserPassword", UserPassword);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void login() {
        Intent welcome = new Intent(this, Welcom.class);
        startActivity(welcome);
        finish();
    }

}