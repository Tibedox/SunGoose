package com.example.sungoose;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    String title = "Потапай гуся!";
    TextView textCounter;
    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textCounter = findViewById(R.id.text2);
        textTitle = findViewById(R.id.text1);
        textTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    public void tapGoose(View view) {
        counter += 1;
        if(counter > 10) {
            title = "Хорошо тапаешь! Продолжай.";
        }
        if(counter > 20) {
            title = "Гусь доволен. Тапай.";
        }
        textTitle.setText(title);
        textCounter.setText("Потапано "+counter+" раз");
    }
}