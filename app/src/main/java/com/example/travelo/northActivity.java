package com.example.travelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class northActivity extends AppCompatActivity {

    private Button btnmapN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);

        btnmapN = (Button) findViewById(R.id.btnmapN);

        btnmapN.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),MapActivity.class);
            startActivity(i);
        });
    }

}
