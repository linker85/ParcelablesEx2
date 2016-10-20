package com.example.com.parcelablesex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String MY_KEY = "parcelable";
    private static final String TAG = "Main2ActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        List<User> users = getIntent().getParcelableArrayListExtra(MY_KEY);
        if (users != null) {
            Log.d(TAG, "onCreate: " + users.toString());
        } else {
            Log.d(TAG, "onCreate: No users");
        }
    }
}
