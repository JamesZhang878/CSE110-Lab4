package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        saveProfile();
        super.onDestroy();
    }

    // Retrieve saved name and status information.
    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String nameStr = preferences.getString("Name", "");
        String statusStr = preferences.getString("Status", "");

        EditText nameView = findViewById(R.id.name_textview);
        EditText statusView = findViewById(R.id.status_textview);

        nameView.setText(nameStr);
        statusView.setText(statusStr);
    }

    // Save name and status information
    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        EditText nameView = findViewById(R.id.name_textview);
        EditText statusView = findViewById(R.id.status_textview);

        editor.putString("Name", nameView.getText().toString());
        editor.putString("Status", statusView.getText().toString());

        editor.apply();
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}