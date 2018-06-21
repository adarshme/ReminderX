package com.example.infernocoder.reminderx;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        welcomeSnackBar();
    }

    public void welcomeSnackBar(){
        Snackbar.make(getWindow().getDecorView().getRootView(), "Add a new reminder", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
