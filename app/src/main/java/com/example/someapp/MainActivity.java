package com.example.someapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    private EditText editBox;
    private TextView firstChar;
    private TextView secondChar;
    private TextView thirdChar;
    private TextView fourthChar;
    private TextView fifthChar;

    private EditText editBox2;
    private TextView firstChar2;
    private TextView secondChar2;
    private TextView thirdChar2;
    private TextView fourthChar2;
    private TextView fifthChar2;

    private EditText editBox3;
    private TextView firstChar3;
    private TextView secondChar3;
    private TextView thirdChar3;
    private TextView fourthChar3;
    private TextView fifthChar3;

    private EditText editBox4;
    private TextView firstChar4;
    private TextView secondChar4;
    private TextView thirdChar4;
    private TextView fourthChar4;
    private TextView fifthChar4;

    private EditText editBox5;
    private TextView firstChar5;
    private TextView secondChar5;
    private TextView thirdChar5;
    private TextView fourthChar5;
    private TextView fifthChar5;

    private TextView triesLeft;

    static List<String> wordsList = Words.validWords;

    static String word;
    static int onLine;
    static int rightCount;
    static int tries;
    static final String INVALID = "Invalid Word";
    static final String WON = "You Won";
    static final String LOST = "You Lost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = getRandomWord();
        onLine = 0;
        tries = 5;
        triesLeft = findViewById(R.id.tries);

        editBox = findViewById(R.id.editBox);
        editBox.setOnEditorActionListener(this);

        firstChar = findViewById(R.id.firstChar);
        secondChar = findViewById(R.id.secondChar);
        thirdChar = findViewById(R.id.thirdChar);
        fourthChar = findViewById(R.id.fourthChar);
        fifthChar = findViewById(R.id.fifthChar);

        editBox2 = findViewById(R.id.editBox2);
        editBox2.setOnEditorActionListener(this);

        firstChar2 = findViewById(R.id.firstChar2);
        secondChar2 = findViewById(R.id.secondChar2);
        thirdChar2 = findViewById(R.id.thirdChar2);
        fourthChar2 = findViewById(R.id.fourthChar2);
        fifthChar2 = findViewById(R.id.fifthChar2);

        editBox3 = findViewById(R.id.editBox3);
        editBox3.setOnEditorActionListener(this);

        firstChar3 = findViewById(R.id.firstChar3);
        secondChar3 = findViewById(R.id.secondChar3);
        thirdChar3 = findViewById(R.id.thirdChar3);
        fourthChar3 = findViewById(R.id.fourthChar3);
        fifthChar3 = findViewById(R.id.fifthChar3);


        editBox4 = findViewById(R.id.editBox4);
        editBox4.setOnEditorActionListener(this);
        firstChar4 = findViewById(R.id.firstChar4);
        secondChar4 = findViewById(R.id.secondChar4);
        thirdChar4 = findViewById(R.id.thirdChar4);
        fourthChar4 = findViewById(R.id.fourthChar4);
        fifthChar4 = findViewById(R.id.fifthChar4);


        editBox5 = findViewById(R.id.editBox5);
        editBox5.setOnEditorActionListener(this);
        firstChar5 = findViewById(R.id.firstChar5);
        secondChar5 = findViewById(R.id.secondChar5);
        thirdChar5 = findViewById(R.id.thirdChar5);
        fourthChar5 = findViewById(R.id.fourthChar5);
        fifthChar5 = findViewById(R.id.fifthChar5);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public static String getRandomWord(){
        return wordsList.get((int)(Math.random()*(wordsList.size()-1)));
    }

    public TextView getChar(int line, int num){
        if(line == 0) {
            if (num == 0) return firstChar;
            else if (num == 1) return secondChar;
            else if (num == 2) return thirdChar;
            else if (num == 3) return fourthChar;
            else return fifthChar;
        } else if (line == 1){
            if (num == 0) return firstChar2;
            else if (num == 1) return secondChar2;
            else if (num == 2) return thirdChar2;
            else if (num == 3) return fourthChar2;
            else return fifthChar2;
        }
        else if (line == 2){
            if (num == 0) return firstChar3;
            else if (num == 1) return secondChar3;
            else if (num == 2) return thirdChar3;
            else if (num == 3) return fourthChar3;
            else return fifthChar3;
        }

        else if (line == 3){
            if (num == 0) return firstChar4;
            else if (num == 1) return secondChar4;
            else if (num == 2) return thirdChar4;
            else if (num == 3) return fourthChar4;
            else return fifthChar4;
        }

        else {
            if (num == 0) return firstChar5;
            else if (num == 1) return secondChar5;
            else if (num == 2) return thirdChar5;
            else if (num == 3) return fourthChar5;
            else return fifthChar5;
        }

    }

    public EditText getEditBox(int line){
        if(line == 0) return editBox;
        else if (line == 1) return editBox2;
        else if (line == 2) return editBox3;
        else if (line == 3 ) return editBox4;
        else return editBox5;
    }

    public boolean isValid(String word){
        String text = getEditBox(onLine).getText().toString().toLowerCase();
        if (text.length() == 5 && wordsList.contains(text)) {
            char c;
            TextView getChar;
            rightCount = 0;
            for (int charNum = 0; charNum < 5; charNum++) {
                c = text.charAt(charNum);
                getChar = getChar(onLine, charNum);
                getChar.setText("" + c);
                if (c == word.charAt(charNum)){
                    getChar.setTextColor(Color.GREEN);
                    rightCount++;
                }
                else if (word.contains("" + c)) getChar.setTextColor(Color.YELLOW);
                else getChar.setTextColor(Color.RED);
                getChar.setVisibility(View.VISIBLE);
            }
            getEditBox(onLine).setVisibility(View.INVISIBLE);
            getEditBox(onLine+1).setVisibility(View.VISIBLE);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        switch (actionId){
            case EditorInfo.IME_ACTION_DONE:
                if(isValid(word) && onLine != 5 && rightCount != 5) {
                    onLine++;
                    tries--;
                    triesLeft.setText(triesLeft.getText().toString().substring(0, triesLeft.getText().length()-1) + tries);
                }

                else if(rightCount == 5){
                    getEditBox(onLine+1).setVisibility(View.INVISIBLE);
                    displayMessage(WON);
                    closeKeyboard();
                }

                else{
                    displayMessage(INVALID);
                }

                if(onLine == 5) {
                    editBox5.setVisibility(View.INVISIBLE);
                    closeKeyboard();
                }

                if(tries == 0 && rightCount != 5){
                    displayMessage(LOST);
                    closeKeyboard();
                }
                break;
            default:
                break;
        }

        return true;
    }

    public void displayMessage(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 50, 420);

        TextView tv = new TextView(this);
        if(message.equalsIgnoreCase(INVALID) || message.equalsIgnoreCase(LOST)) tv.setBackgroundColor(Color.RED);
        else tv.setBackgroundColor(Color.GREEN);
        Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
        tv.setTypeface(t);
        tv.setTextSize(25);
        tv.setText(message);
        tv.setPadding(5, 5, 5, 5);
        toast.setView(tv);
        toast.show();
    }

    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                onLine = 0;
                tries = 5;
                triesLeft.setText(triesLeft.getText().toString().substring(0, triesLeft.getText().length()-1) + tries);
                for(int i = 1; i < 5; i++){
                    getEditBox(i).setVisibility(View.INVISIBLE);

                    for(int j = 0; j < 5; j++){
                        getChar(0, j).setVisibility(View.INVISIBLE);
                        getChar(i, j).setVisibility(View.INVISIBLE);
                    }
                }
                getEditBox(0).setVisibility(View.VISIBLE);
                for(int i = 0; i < 5; i++){
                    getEditBox(i).setText("");
                }
                word = getRandomWord();
                break;

            default:
                break;
        }
    }
}