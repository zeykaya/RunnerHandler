package com.kaya.runnerhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        number=0;
        button=findViewById(R.id.button);

        }
            public void start(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
            textView.setText("time:"+number);
            number++;
            textView.setText("time:"+number);
            handler.postDelayed(runnable,1000);//runnable kaç saniyede çalışsın
            }
        };
        handler.post(runnable);
        button.setEnabled(false);//butona tekrar basılmasın diye

        }
            public void stop(View view){
        button.setEnabled(true);//stop butonunu aktif etmek için
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("time:"+number);


            }
    }

