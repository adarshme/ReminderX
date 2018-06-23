package com.example.infernocoder.reminderx;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NewReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        welcomeSnackBar();
    }

    public void welcomeSnackBar() {
        Snackbar.make(getWindow().getDecorView().getRootView(), "Add a new reminder", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    Button PickTime;

    public void timeDialog(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        PickTime = findViewById(R.id.PickTime);
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(NewReminder.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String PickTimeText = selectedHour + " : " + selectedMinute;
                PickTime.setText(PickTimeText);
            }
        }, hour, minute, false);//No 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    EditText Heading;

    public void addReminder(View view) {
        Heading = findViewById(R.id.Heading);
        PickTime = findViewById(R.id.PickTime);

        String ToastMessage = "Added " + Heading.getText().toString() + " for " + PickTime.getText();

        Toast.makeText(getBaseContext(), ToastMessage,
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(NewReminder.this, MainActivity.class);
        startActivity(intent);
    }
}
