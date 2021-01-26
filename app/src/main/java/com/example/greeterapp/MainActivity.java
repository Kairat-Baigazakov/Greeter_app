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

    static String name;
    private static final String greet = "Hello, ";
    private static final String end = "!";
    private static final String NAME_KEY = "Unknow";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(NAME_KEY, name);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String textViewText = savedInstanceState.getString(NAME_KEY);
        TextView nameView = findViewById(R.id.text);
        if (textViewText.isEmpty()) {
            nameView.setText("Уважаемый пользователь, эта высокотехнологическая программа создана для того чтобы приветсвовать кого-либо. Соизвольте написать своё имя или в конце то концов хоть что-нибудь, это же программа и ей наплевать кого приветсвовать!");
        }
        else {
            nameView.setText(greet + textViewText + end);
        }
    }

    public void greet (View view) {
        EditText nameBox = findViewById(R.id.editTextTextPersonName);
        name = nameBox.getText().toString();
        TextView nameView = findViewById(R.id.text);
        if (name.isEmpty()){
            nameView.setText("Уважаемый пользователь, эта высокотехнологическая программа создана для того чтобы приветсвовать кого-либо. Соизвольте написать своё имя или в конце то концов хоть что-нибудь, это же программа и ей наплевать кого приветсвовать!");
        }
        else {
            nameView.setText(greet + name + end);
        }
    }
}