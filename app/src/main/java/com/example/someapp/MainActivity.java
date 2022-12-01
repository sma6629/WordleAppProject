package com.example.someapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText editBox;
    private TextView firstChar;
    private TextView secondChar;
    private TextView thirdChar;
    private TextView fourthChar;
    private TextView fifthChar;

    private static List<String> wordsList = new ArrayList<>(
    List.of("aback", "abase", "abate", "abbey", "abbot", "abhor",
            "abide", "abled", "abode", "abort", "about", "above",
            "abuse", "abyss",
            "acorn", "acrid", "actor", "acute",
            "adage", "adapt", "adept", "admin", "admit", "adobe", "adopt", "adore"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBox = findViewById(R.id.editBox);
        editBox.setTop(600);
        editBox.setOnEditorActionListener(this);
        editBox.setImeActionLabel("ENTER", KeyEvent.KEYCODE_ENTER);

        firstChar = findViewById(R.id.firstChar);
        secondChar = findViewById(R.id.secondChar);
        thirdChar = findViewById(R.id.thirdChar);
        fourthChar = findViewById(R.id.fourthChar);
        fifthChar = findViewById(R.id.fifthChar);
    }

    public String getRandomWord(){
        return wordsList.get((int)(Math.random()*(wordsList.size()-1)));
    }

    public TextView getChar(int num){
        if (num == 0) return firstChar;
        else if (num == 1) return secondChar;
        else if (num == 2) return thirdChar;
        else if (num == 3) return fourthChar;
        else return fifthChar;
    }

    public void checkWord(String word){
        String text = ""+editBox.getText();
        if (text.length() == 5 && wordsList.contains(text)) {
            System.out.println(word);

            char c;
            TextView getChar;
            for (int i = 0; i < 5; i++) {
                c = text.charAt(i);
                getChar = getChar(i);
                getChar.setText("" + c);
                if (c == word.charAt(i)) getChar.setTextColor(Color.GREEN);
                else if (word.contains("" + c)) getChar.setTextColor(Color.YELLOW);
                else getChar.setTextColor(Color.RED);
                getChar.setVisibility(View.VISIBLE);
            }
            editBox.setVisibility(View.INVISIBLE);
        } else Toast.makeText(this, "invalid word", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        switch (actionId){
            case EditorInfo.IME_ACTION_DONE:
                checkWord(getRandomWord());
                break;

            default:
                break;
        }

        return true;
    }
}