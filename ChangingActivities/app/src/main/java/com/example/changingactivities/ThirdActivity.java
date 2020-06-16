package com.example.changingactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    String  NameHolder;
    TextView str;
    Button LogOUT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        str = (TextView)findViewById(R.id.textView1);

        LogOUT = (Button)findViewById(R.id.button1);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        NameHolder = intent.getStringExtra(MainActivity.UserName);

        // Setting up received email to TextView.
        str.setText(str.getText().toString()+ NameHolder);


        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(ThirdActivity.this,"Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });

    }
}