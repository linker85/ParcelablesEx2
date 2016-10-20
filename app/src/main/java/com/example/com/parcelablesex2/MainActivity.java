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
    public static final int REQUEST_KEY = 10;
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

    // Tells something to android system from our app. Ex pass coordinates from our app to a Google map
    // 1. set and action (Android does not know who is going to manage)
    public void implicitIntent(View view) {
        // Create the text message with a string
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);// if we add a filter in the manifest we can add them in the setAction to open filtered 3erd party tools
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Edwin is the best");
        sendIntent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        // If email -> the message goes to the body
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    // Knows what exact class it has to show, you pass fully qualified name
    public void explicitIntent(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    // Creates a 2 way binding (Can send data without creating a new intent)
    public void startActivityForResult(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, REQUEST_KEY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "requestCode: " + requestCode);
        Log.d(TAG, "onActivityResult: " + resultCode);
        Log.d(TAG, "onActivityResult: " + data.getStringExtra(Main2Activity.MY_KEY_RESULT));
    }
}
