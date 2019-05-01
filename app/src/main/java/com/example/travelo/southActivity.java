package com.example.travelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class southActivity extends AppCompatActivity {
    private Button btnmapS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);

        btnmapS = (Button) findViewById(R.id.btnmapS);

        btnmapS.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),MapSouthActivity.class);
            startActivity(i);
        });
    }
}
