package com.sai.info.collins.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sai.info.collins.R;

import java.util.ArrayList;

public class LastDigit extends AppCompatActivity {

    static ArrayList array;
    EditText numberET,powerET;
    TextView displayDigit;
    ImageButton calculate;
    String number;
    String power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_digit);
        array=new ArrayList();

        init();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=numberET.getText().toString();
                power=powerET.getText().toString();
                if(number.isEmpty() || power.isEmpty()){
                    displayDigit.setText("Invalid input");
                }else{
                    calculateValue();
                }
            }
        });

    }

    private void calculateValue() {
        String lastDigitOfNum=getLastDigit(number);
        getPatterns(Integer.parseInt(lastDigitOfNum));
        int remain=(Integer.parseInt(power)%array.size());

        printFinalLastDigit(remain);
    }

    private void printFinalLastDigit(int remain) {
        if(remain==0){
            displayDigit.setText("Last digit is "+array.get(array.size()-1));
        }else{
            displayDigit.setText("Last digit is "+array.get(remain-1));

        }
        array.clear();
    }

    private void getPatterns(int num) {
        for(int i=1;i<5;i++){
            int number=powerr(num,i);         // get number
            String lastDigit=getLastDigit(""+number);

            if(array.contains(lastDigit)){
                i=5;
            }else{
                array.add(lastDigit);
            }

        }
    }

    private String getLastDigit(String n) {

        int num=Integer.parseInt(n);
        int divident=n.length()-1;
        if(num>10){
            num=Integer.parseInt(getLastDigit(""+num%(powerr(10,divident))));
        }
        return ""+num;
    }

    private int powerr(int i, int length) {
        int sum=1;
        int count=1;
        do{
            sum=sum*i;
            count++;
        }while (count<=length);
        return sum;
    }

    private void init() {
        numberET=(EditText)findViewById(R.id.number);
        powerET=(EditText)findViewById(R.id.power);
        calculate=(ImageButton)findViewById(R.id.okey);
        displayDigit=(TextView)findViewById(R.id.display);
    }
}
