package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Welcom extends AppCompatActivity {

    private EditText CUsername, CUserPassword;
    private TextView CTextView;
    private Button CButton;
    private String Username, UserPassword;
    private String URL = "http://192.168.1.8/server/login.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        Username = UserPassword = "";
        CUsername = findViewById(R.id.CUsername);
        CUserPassword = findViewById(R.id.CUserPassword);
        CButton = findViewById(R.id.CButton);
        CTextView = findViewById(R.id.CTextView);

        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        CTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    public void login() {
        Username = CUsername.getText().toString().trim();
        UserPassword = CUserPassword.getText().toString().trim();
        if(!Username.equals("") && !UserPassword.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("res", response);
                    if (response.equals("success")) {
                        Intent hotels = new Intent(Welcom.this, Accueil.class);
                        hotels.putExtra("keyname", CUsername.getText().toString());
                        startActivity(hotels);
                        finish();
                    } else if (response.equals("failure")) {
                        Toast.makeText(Welcom.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Welcom.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("Username", Username);
                    data.put("UserPassword", UserPassword);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void register() {
        Intent inscription = new Intent(this, Inscription.class);
        startActivity(inscription);
        finish();
    }

}