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

public class annaba1 extends AppCompatActivity {

    private ImageView CImageViewBack;
    ImageButton cancelButton, cancelButton1, cancelButton2;
    Button ok_btn, ok_btn4, ok_btn3, ok_btn2 , ok_btn1;
    private String URL = "http://172.20.10.2/server/check_availability.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annaba1);

        CImageViewBack = findViewById(R.id.CImageViewBack);
        CImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        View alertCustomDialog = LayoutInflater.from(annaba1.this).inflate(R.layout.custom_dialog,null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(annaba1.this);

        View alertCustomDialog1 = LayoutInflater.from(annaba1.this).inflate(R.layout.custom_dialog1,null);
        AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(annaba1.this);

        View alertCustomDialog2 = LayoutInflater.from(annaba1.this).inflate(R.layout.custom_dialog2,null);
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(annaba1.this);

        alertDialog.setView(alertCustomDialog);
        alertDialog1.setView(alertCustomDialog1);
        alertDialog2.setView(alertCustomDialog2);

        cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        cancelButton1 = (ImageButton) alertCustomDialog1.findViewById(R.id.cancelID);
        cancelButton2 = (ImageButton) alertCustomDialog2.findViewById(R.id.cancelID);

        ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);
        ok_btn1 = (Button) alertCustomDialog1.findViewById(R.id.ok_btn_id1);
        ok_btn2 = (Button) alertCustomDialog1.findViewById(R.id.ok_btn_id2);
        ok_btn3 = (Button) alertCustomDialog1.findViewById(R.id.ok_btn_id3);
        ok_btn4 = (Button) alertCustomDialog1.findViewById(R.id.ok_btn_id4);
        ok_btn2 = (Button) alertCustomDialog2.findViewById(R.id.ok_btn_id2);

        final AlertDialog dialog = alertDialog.create();
        final AlertDialog dialog1 = alertDialog1.create();
        final AlertDialog dialog2 = alertDialog2.create();

        findViewById(R.id.LinearLayoutR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });

        ok_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog1.cancel();
            }
        });

        ok_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog1.cancel();
            }
        });
        ok_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog1.cancel();
            }
        });
        ok_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog1.cancel();
            }
        });

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
                dialog.cancel();
                Toast.makeText(annaba1.this, "Sent succesfuly", Toast.LENGTH_SHORT).show();
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

            }
        });
        cancelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.cancel();

            }
        });
        cancelButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.cancel();
            }
        });

    }

    public void Back() {
        Intent inscription = new Intent(this, HotelsAnnaba.class);
        startActivity(inscription);
        finish();
    }

}