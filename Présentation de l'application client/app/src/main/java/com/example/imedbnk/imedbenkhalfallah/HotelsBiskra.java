package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HotelsBiskra extends AppCompatActivity {

    private ConstraintLayout ConstraintLayout1, ConstraintLayout2, ConstraintLayout3, ConstraintLayout4;
    private ConstraintLayout Hotel1, Hotel2,  Hotel3;
    TextView textView;
    private TextView textViewA, textViewB, textViewC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_biskra);

        textView = findViewById(R.id.textView2);
        String Username = getIntent().getStringExtra("keyname");
        textView.setText(Username);

        ConstraintLayout1 = findViewById(R.id.ConstraintLayout1);
        ConstraintLayout2 = findViewById(R.id.ConstraintLayout2);
        ConstraintLayout3 = findViewById(R.id.ConstraintLayout3);
        ConstraintLayout4 = findViewById(R.id.ConstraintLayout4);
        Hotel1 = findViewById(R.id.Hotel1);
        Hotel2 = findViewById(R.id.Hotel2);
        Hotel3 = findViewById(R.id.Hotel3);

        ConstraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login1();
            }
        });

        ConstraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login2();
            }
        });

        ConstraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login3();
            }
        });

        ConstraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login4();
            }
        });

        Hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login5();
            }
        });

        Hotel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login6();
            }
        });

        Hotel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login7();
            }
        });

        textViewA = findViewById(R.id.textViewA);
        RadioGroup priceRadioGroup = findViewById(R.id.priceRadioGroup);
        priceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioButton1) {
                    textViewA.setText("Prix: 70 €");
                } else if (checkedId == R.id.RadioButton2) {
                    textViewA.setText("Prix: 198 €");
                } else if (checkedId == R.id.RadioButton3) {
                    textViewA.setText("Prix: 342 €");
                }
            }
        });

        textViewB = findViewById(R.id.textViewB);
        RadioGroup priceRadioGroup2 = findViewById(R.id.priceRadioGroup2);
        priceRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioButton4) {
                    textViewB.setText("Prix: 117 €");
                } else if (checkedId == R.id.RadioButton5) {
                    textViewB.setText("Prix: 245 €");
                } else if (checkedId == R.id.RadioButton6) {
                    textViewB.setText("Prix: 389 €");
                }
            }
        });

        textViewC = findViewById(R.id.textViewC);
        RadioGroup priceRadioGroup3 = findViewById(R.id.priceRadioGroup3);
        priceRadioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RadioButton7) {
                    textViewC.setText("Prix: 85 €");
                } else if (checkedId == R.id.RadioButton8) {
                    textViewC.setText("Prix: 213 €");
                } else if (checkedId == R.id.RadioButton9) {
                    textViewC.setText("Prix: 357 €");
                }
            }
        });

    }

    public void login1() {
        Intent hotelsAlger = new Intent(this, HotelsAlger.class);
        hotelsAlger.putExtra("keyname", textView.getText().toString());
        startActivity(hotelsAlger);
        finish();
    }
    public void login2() {
        Intent hotelsAnnaba = new Intent(this, HotelsAnnaba.class);
        hotelsAnnaba.putExtra("keyname", textView.getText().toString());
        startActivity(hotelsAnnaba);
        finish();
    }

    public void login3() {
        Intent hotelsOran = new Intent(this, HotelsOran.class);
        hotelsOran.putExtra("keyname", textView.getText().toString());
        startActivity(hotelsOran);
        finish();
    }

    public void login4() {
        Intent hotelsBiskra = new Intent(this, HotelsBiskra.class);
        hotelsBiskra.putExtra("keyname", textView.getText().toString());
        startActivity(hotelsBiskra);
        finish();
    }

    public void login5() {
        Intent hotelalger1 = new Intent(this, setif1.class);
        startActivity(hotelalger1);
        finish();
    }

    public void login6() {
        Intent hotelalger2 = new Intent(this, setif2.class);
        startActivity(hotelalger2);
        finish();
    }

    public void login7() {
        Intent hotelalger3 = new Intent(this, setif3.class);
        startActivity(hotelalger3);
        finish();
    }

}