package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View v){
        String message = ((EditText)(findViewById(R.id.editText_message))).getText().toString();
        Uri destination = Uri.parse("smsto:9723964838");
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);
    }
}
