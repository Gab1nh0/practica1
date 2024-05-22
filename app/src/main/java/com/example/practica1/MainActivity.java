package com.example.practica1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton rd1, rd2;

    private EditText et1, et2;

    private CheckBox cb1;


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

            et1 = findViewById(R.id.et1);
            et2 = findViewById(R.id.et2);

            cb1 = findViewById(R.id.cb1);


            if (cb1.isChecked()) {
                et2.setEnabled(false);
                et2.setText(String.valueOf(0.00f));
            } else {
                et2.setEnabled(true);
            }


            rd1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rd2.setChecked(false);
                    rd1.setChecked(true);

                    float precio, bono, meses, res;

                    precio = Float.parseFloat(et1.getText().toString());
                    bono = Float.parseFloat(et2.getText().toString());
                    meses = 84;

                    res = precio + bono / meses;

                    Intent intent = new Intent(this, Activity2.class);
                    intent.putExtra("res", res); // Estás pasando un entero
                    startActivity(intent);
                }
            });

            rd2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rd1.setChecked(false);
                    rd2.setChecked(true);

                    float precio, bono, meses, res;

                    precio = Float.parseFloat(et1.getText().toString());
                    bono = Float.parseFloat(et2.getText().toString());
                    meses = 84;

                    res = precio * bono / meses;

                    Intent intent = new Intent(this, Activity2.class);
                    intent.putExtra("res", res);
                    startActivity(intent);

                }
            });





            return insets;
        });
    }

}
