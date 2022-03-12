package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private Button buttonPlus, buttonMinus, buttonC, buttonChange, buttonDivision, buttonMultiplication, buttonEquals;
    private Button buttonDot, buttonPercent;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        button0 = (Button) findViewById(R.id.buttonZero);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonC = (Button) findViewById(R.id.button_C);
        buttonDot = (Button) findViewById(R.id.button_dot);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonChange = (Button) findViewById(R.id.button_change);
        buttonEquals = (Button) findViewById(R.id.button_equals);
        buttonPercent = (Button) findViewById(R.id.button_percent);
        buttonDivision = (Button) findViewById(R.id.button_division);
        buttonMultiplication = (Button) findViewById(R.id.button_multiplication);

        textView = (TextView) findViewById(R.id.textView);

        onClickButton(button1, "1");
        onClickButton(button2, "2");
        onClickButton(button3, "3");
        onClickButton(button4, "4");
        onClickButton(button5, "5");
        onClickButton(button6, "6");
        onClickButton(button7, "7");
        onClickButton(button8, "8");
        onClickButton(button9, "9");
        button0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String result;
                try {
                    result = (String) textView.getText();
                } catch (Exception e) {
                    result = "0";
                }
                if (result.charAt(0) =='0'){
                    textView.setText(result);
                }
                else {
                    result += 0;
                    textView.setText(result);
                }

            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
            }
        });
    }

    public void onClickButton(Button buttonLocal, String symbol) {
        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String result;
                try {
                    result = (String) textView.getText();
                    if (result.charAt(0) =='0'){
                        textView.setText("");
                    }
                } catch (Exception e) {
                    result = "0";
                }

                result += symbol;
                textView.setText(result);
            }
        });
    }
}