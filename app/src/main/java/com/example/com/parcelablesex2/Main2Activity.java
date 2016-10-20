package com.example.com.parcelablesex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String MY_KEY = "parcelable";
    private static final String TAG = "Main2ActivityTAG_";
    public static final String MY_KEY_RESULT = "MY_RESULT_KEY";

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

    public void startActivityForResultBack(View view) {
        Intent intent = new Intent();
        intent.putExtra(MY_KEY_RESULT, "RESULT_FROM_SECOND");
        setResult(MainActivity.REQUEST_KEY, intent); // Send the intent back to the main activity
        finish();
    }
}
