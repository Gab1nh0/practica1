package com.example.practica1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton rd1, rd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            rd1 = findViewById(R.id.rd1);
            rd2 = findViewById(R.id.rd2);



            rd1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rd2.setChecked(false);
                    rd1.setChecked(true);

                    Intent intent = new Intent(this, Activity2.class);
                    startActivity(intent);


                }
            });

            rd2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rd1.setChecked(false);
                    rd2.setChecked(true);
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    startActivity(intent);
                }
            });



            return insets;
        });
    }

}