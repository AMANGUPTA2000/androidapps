package com.example.yourdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name, ID, Email, Mobile, updateold, updatenew, delete, searchval;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.editName);
        ID = (EditText) findViewById(R.id.identy);
        Email = (EditText) findViewById(R.id.editEmail);
        Mobile = (EditText) findViewById(R.id.editMobile);
        updateold = (EditText) findViewById(R.id.editText4);
        updatenew = (EditText) findViewById(R.id.editText5);
        delete = (EditText) findViewById(R.id.editText6);
        searchval = (EditText) findViewById(R.id.editText7);
        helper = new myDbAdapter(this);

    }

    public void addUser(View view) {
        String t1 = ID.getText().toString();
        String t2 = Name.getText().toString();
        String t3 = Email.getText().toString();
        String t4 = Mobile.getText().toString();

        if (t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty()) {
            Message.message(getApplicationContext(), "Enter All Details");
        } else {
            long id = helper.insertData(t1, t2, t3, t4);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                ID.setText("");
                Name.setText("");
                Email.setText("");
                Mobile.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                ID.setText("");
                Name.setText("");
                Email.setText("");
                Mobile.setText("");
            }
        }
    }

    public void viewdata(View view) {
        String data = helper.getData();
        Message.message(this, data);
    }

    public void update(View view) {
        String u2 = updateold.getText().toString();
        String u3 = updatenew.getText().toString();
        if (u2.isEmpty() || u3.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.updateName(u2, u3);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Please Check the ID");
                updateold.setText("");
                updatenew.setText("");
            } else {
                Message.message(getApplicationContext(), "Updated");
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }

    public void delete(View view) {
        String iden = delete.getText().toString();
        if (iden.isEmpty()) {
            Message.message(getApplicationContext(), "Enter ID");
        } else {
            int a = helper.delete(iden);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Please Enter Correct ID");
                delete.setText("");
            } else {
                Message.message(this, "DELETED");
                delete.setText("");
            }
        }
    }

    public void searc(View view) {
        String val = searchval.getText().toString();
        String result = helper.getres(val);
        if(val.isEmpty()) {
            Message.message(getApplicationContext(), "Enter ID to search");
            searchval.setText("");
        }
        else if (result.isEmpty()) {
            Message.message(getApplicationContext(), "Not found");
            searchval.setText("");
        }
        else {
            Message.message(this, result);
            searchval.setText("");
        }
    }
}