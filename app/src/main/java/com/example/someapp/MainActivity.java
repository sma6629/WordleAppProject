package com.example.someapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        firstChar = findViewById(R.id.firstChar);
        secondChar = findViewById(R.id.secondChar);
        thirdChar = findViewById(R.id.thirdChar);
        fourthChar = findViewById(R.id.fourthChar);
        fifthChar = findViewById(R.id.fifthChar);

        AppCompatButton button = findViewById(R.id.enterBtn);
        button.setOnClickListener(this);
    }

    public String getRandomWord(){
        return wordsList.get((int)(Math.random()*(wordsList.size()-1)));
    }

    public TextView getChar(int num){
        if (num == 0) return firstChar;
        else if (num == 1) return secondChar;
        else if (num == 2) return thirdChar;
        else if (num == 3) return  fourthChar;
        else return fifthChar;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enterBtn:

                String text = ""+editBox.getText();
                if (text.length() == 5 && wordsList.contains(text)) {
                    String word = getRandomWord();
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

                break;
            default:
                break;
        }
    }

}