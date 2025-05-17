package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Button btn = findViewById(R.id.button2);
        EditText num1 = findViewById(R.id.editTextText);
        EditText num2 = findViewById(R.id.editTextText2);
        try {
            btn.setOnClickListener(view -> {
                int result = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                Toast.makeText(this, "Result is: " + result, Toast.LENGTH_SHORT).show();
            });
        } catch (NumberFormatException e){
            Toast.makeText(this, "Error while sum number!!!", Toast.LENGTH_SHORT).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}