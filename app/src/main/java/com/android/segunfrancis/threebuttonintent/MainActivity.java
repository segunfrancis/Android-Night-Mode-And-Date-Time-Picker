package com.android.segunfrancis.threebuttonintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String PASSAGE_ITEM = "passage_item";
    public static final String PREF_KEY = "preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieving theme from shared preference and Setting the app theme
        SharedPreferences sp = getSharedPreferences(
                PREF_KEY, Activity.MODE_PRIVATE);
        int theme = sp.getInt(PassageActivity.STATE_THEME, 0);
        AppCompatDelegate.setDefaultNightMode(theme);
    }

    public void openPassageActivity(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.passage1:
                intent(getResources().getString(R.string.first_passage));
                break;
            case R.id.passage2:
                intent(getResources().getString(R.string.second_passage));
                break;
            case R.id.passage3:
                intent(getResources().getString(R.string.third_passage));
                break;
        }
    }

    private void intent(String passage) {
        Intent intent = new Intent(this, PassageActivity.class);
        intent.putExtra(PASSAGE_ITEM, passage);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_picker, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_picker) {
            startActivity(new Intent(this, DateAndTimePickerActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
