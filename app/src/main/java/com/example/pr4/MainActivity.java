package com.example.pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;



    int guess;

    boolean gameFinished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);

        guess = (int)(Math.random()*100);
        gameFinished = false;
    }



    public void onClick(View v){

        if(!gameFinished) {
            if (!etInput.getText().toString().isEmpty()) {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp > guess)
                    tvInfo.setText("Перебор");
                if (inp < guess)
                    tvInfo.setText("Недобор");
                if (inp == guess) {
                    tvInfo.setText("Четко в цель харош харош лучший просто нереально ");
                    bControl.setText("Сыграть ещкере");
                    gameFinished = true;
                }
                if (inp < 0 || inp > 100)
                    tvInfo.setText("Ошипка");
            } else {
                Toast.makeText(this, "Пожалуйста, введите значение", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение");
            tvInfo.setText("Попробуй угадать число (1-100)");
            gameFinished = false;
        }
        etInput.setText("");


    }
}