package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private TextView Score;
    private static final String TAG = "Whack-A-Mole!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = (Button) findViewById(R.id.Button1);
        Button2 = (Button) findViewById(R.id.Button2);
        Button3 = (Button) findViewById(R.id.Button3);
        Score = (TextView) findViewById(R.id.Score);

        placeMole();

        Button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button Left Clicked!");
                if (Button1.getText() == "*") {
                    addScore();
                } else {
                    deductScore();
                }
                placeMole();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button Middle Clicked!");
                if (Button2.getText() == "*") {
                    addScore();
                } else {
                    deductScore();
                }
                placeMole();
            }
        });

        Button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button Right Clicked!");
                if (Button3.getText() == "*") {
                    addScore();
                } else {
                    deductScore();
                }
                placeMole();
            }
        });
    }
    public void addScore() {
        int currentScore = Integer.parseInt(Score.getText().toString());
        Log.v(TAG, "Hit, score added!");
        currentScore = currentScore + 1;
        Score.setText(Integer.toString(currentScore));
    }
    public void deductScore() {
        int currentScore = Integer.parseInt(Score.getText().toString());
        Log.v(TAG, "Missed, score deducted!");
        if (currentScore > 0) {
            currentScore = currentScore - 1;
        }
        Score.setText(Integer.toString(currentScore));
    }
    public void placeMole() {
        switch (new Random().nextInt(3)+1) {
            case 1:
                Button1.setText("*");
                Button2.setText("O");
                Button3.setText("O");
                break;
            case 2:
                Button1.setText("O");
                Button2.setText("*");
                Button3.setText("O");
                break;
            case 3:
                Button1.setText("O");
                Button2.setText("O");
                Button3.setText("*");
                break;
        }
    }
}
