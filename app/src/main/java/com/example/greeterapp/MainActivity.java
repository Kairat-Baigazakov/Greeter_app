package com.example.greeterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String name = "Unknow";
    private static final String greet = "Hello ";
    private static final String end = "!";
    private static final String NAME_KEY = "Unknow";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        TextView nameView = findViewById(R.id.text);
        outState.putString(NAME_KEY, name);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String textViewText = savedInstanceState.getString(NAME_KEY);
        TextView nameView = findViewById(R.id.text);
        nameView.setText(greet + textViewText + end);

    }

    public void greet (View view) {
        EditText nameBox = findViewById(R.id.editTextTextPersonName);
        name = nameBox.getText().toString();
        TextView nameView = findViewById(R.id.text);
        nameView.setText(greet + name + end);
    }
}