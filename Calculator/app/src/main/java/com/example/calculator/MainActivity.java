package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView t1;
    String s1, s2, result;
    double num1, num2;
    Button add, sub, multi, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.no1);
        e2 = (EditText) findViewById(R.id.no2);
        t1 = (TextView) findViewById(R.id.answer);

        add = (Button) findViewById(R.id.addnum);
        sub = (Button) findViewById(R.id.subnum);
        multi = (Button) findViewById(R.id.mulnum);
        div = (Button) findViewById(R.id.divnum);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSum();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSub();
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doMul();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doDiv();
            }
        });
    }

    public boolean getNumbers() {

        s1 = e1.getText().toString();
        s2 = e2.getText().toString();

        if ((s1.equals(null)) || (s1.equals(""))) {

            Toast.makeText(MainActivity.this, "Please Enter number 1!", Toast.LENGTH_SHORT).show();
            result = "Please enter 1st number ";
            t1.setText(result);

            return false;
        }
        else if ((s2.equals(null)) || (s2.equals(""))) {

            Toast.makeText(MainActivity.this, "Please Enter number 2!", Toast.LENGTH_SHORT).show();
            result = "Please enter 2nd number";
            t1.setText(result);

            return false;
        }
        else {

            num1 = Double.parseDouble(e1.getText().toString());
            num2 = Double.parseDouble(e2.getText().toString());
        }

        return true;
    }
    public void doSum()
    {
        if (getNumbers()) {
            double sum = num1 + num2;
            t1.setText(Double.toString(sum));
        }
    }

    public void doSub()
    {
        if (getNumbers()) {
            double sum = num1 - num2;
            t1.setText(Double.toString(sum));
        }
    }

    public void doMul()
    {
        if (getNumbers()) {
            double sum = num1 * num2;
            t1.setText(Double.toString(sum));
        }
    }

    public void doDiv()
    {
        if (getNumbers()) {

            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
    }

}