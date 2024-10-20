package com.example.sungoose;

import android.os.Bundle;
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
        switch (counter) {
            case 10: title = "Хорошо тапаешь! Продолжай."; break;
            case 21:
            case 22: title = "Гусь доволен. Тапай."; break;
            case 30: title = "Да ты просто гений!"; break;
            default: title = "Тапай гуся аккуратно.";
        }

        textTitle.setText(title);
        if(counter%10>1 && counter%10<5 && counter/10%10!=1){
            textCounter.setText("Потапано "+counter+" раза");
        } else {
            textCounter.setText("Потапано " + counter + " раз");
        }
    }
}