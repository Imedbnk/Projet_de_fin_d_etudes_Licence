package com.example.imedbnk.imedbenkhalfallah;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linearLayout = findViewById(R.id.linear_layout);
        fetchData();
    }

    private void fetchData() {
        new Thread(() -> {
            try {
                URL url = new URL("http://192.168.1.8/server/disponibilite.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                JSONArray jsonArray = new JSONArray(response.toString());
                runOnUiThread(() -> {
                    try {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String typeDeLit = object.getString("type_de_lit");
                            String nbrPersonne = object.getString("nbr_personne");
                            String chambreLit = object.getString("chambre_lit");
                            String prix = object.getString("Prix");
                            TextView textView = new TextView(this);
                            textView.setText(typeDeLit + " - " + nbrPersonne + " - " + chambreLit + " - " + prix);
                            linearLayout.addView(textView);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
