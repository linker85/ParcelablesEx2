package com.example.com.parcelablesex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String MY_KEY = "parcelable";
    private static final String TAG = "MainActivityTAG_";
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<User>();
    }

    public void addToArray(View view) {
        EditText e = (EditText) findViewById(R.id.name);
        String name = e.getText().toString();
        Log.d(TAG, "addToArray: " + name);
        User user = new User();
        user.setName(name);
        Log.d(TAG, "user != null: " + (user != null));
        if (user != null) {
            users.add(user);
            if (!users.isEmpty()) {
                String text = user.getName() + " was added, 1/" + users.size();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(MY_KEY, users);
        startActivity(intent);
    }
}
