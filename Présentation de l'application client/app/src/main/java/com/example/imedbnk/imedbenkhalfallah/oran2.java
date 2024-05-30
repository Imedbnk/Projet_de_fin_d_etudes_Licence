package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class oran2 extends AppCompatActivity {

    private ImageView CImageViewBack;
    ImageButton cancelButton;
    Button ok_btn, ok_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oran2);

        CImageViewBack = findViewById(R.id.CImageViewBack);
        CImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        View alertCustomDialog = LayoutInflater.from(oran2.this).inflate(R.layout.custom_dialog,null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(oran2.this);

        View alertCustomDialog2 = LayoutInflater.from(oran2.this).inflate(R.layout.custom_dialog2,null);
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(oran2.this);

        alertDialog.setView(alertCustomDialog);
        alertDialog2.setView(alertCustomDialog2);

        cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);
        ok_btn2 = (Button) alertCustomDialog2.findViewById(R.id.ok_btn_id2);

        final AlertDialog dialog = alertDialog.create();
        final AlertDialog dialog2 = alertDialog2.create();

        findViewById(R.id.LinearLayoutR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
                dialog.cancel();
                Toast.makeText(oran2.this, "Sent succesfuly", Toast.LENGTH_SHORT).show();
            }
        });

        ok_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.cancel();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialog2.cancel();
            }
        });

    }

    public void Back() {
        Intent inscription = new Intent(this, HotelsOran.class);
        startActivity(inscription);
        finish();
    }

}