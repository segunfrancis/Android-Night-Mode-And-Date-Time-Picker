package com.android.segunfrancis.threebuttonintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DateAndTimePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = day_string + "/" + month_string + "/" + year_string;
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string;
        String minute_string;
        String timeMessage;
        if (hour > 12) {
            hour_string = Integer.toString(hour - 12);
            minute_string = Integer.toString(minute);
            timeMessage = hour_string + ":" + minute_string + " pm";
            Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
        } else {
            hour_string = Integer.toString(hour);
            minute_string = Integer.toString(minute);
            timeMessage = hour_string + ":" + minute_string + " am";
            Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
