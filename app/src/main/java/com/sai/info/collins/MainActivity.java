package com.sai.info.collins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sai.info.collins.activities.LastDigit;

public class MainActivity extends AppCompatActivity {

    Button lastDigit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        lastDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LastDigit.class));
            }
        });
    }


    private void init() {
        lastDigit=(Button)findViewById(R.id.lastDigit);
    }
}
