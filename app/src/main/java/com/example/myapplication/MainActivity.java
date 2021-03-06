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
    private TextView textView, textView2, textView3, textView4, textView5;
    private String mainSymbol;
    private String firstNumber;


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
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);

        onClickButton(button1, "1");
        onClickButton(button2, "2");
        onClickButton(button3, "3");
        onClickButton(button4, "4");
        onClickButton(button5, "5");
        onClickButton(button6, "6");
        onClickButton(button7, "7");
        onClickButton(button8, "8");
        onClickButton(button9, "9");
        onClickButton(buttonDot, ".");
        onClickOperationButton(buttonPlus, "+");
        onClickOperationButton(buttonMinus, "-");
        onClickOperationButton(buttonDivision, "/");
        onClickOperationButton(buttonMultiplication, "*");
        onClickOperationButton(buttonPercent, "%");
        // ???????????????? ?????????? ???????????????? ???? buttonChange
        // ???????????????? ?????????? ?????????????? ???? buttonEquals
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
                if (result.charAt(0) == '0') {
                    textView.setText(result);
                } else {
                    result += 0;
                    textView.setText(result);
                }

            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    double numberOne = Double.parseDouble(firstNumber);
                    double numberTwo = Double.parseDouble((String) textView.getText());
                    double result = 0;
                    textView2.setText(firstNumber);
                    textView3.setText(mainSymbol);
                    textView4.setText(Double.toString(numberTwo));
                    textView5.setText("=");
                    switch (mainSymbol) {
                        case "+":
                            result = numberOne + numberTwo;
                            firstNumber = String.valueOf(numberOne);
                            break;
                        case "-":
                            result = numberOne - numberTwo;
                            firstNumber = String.valueOf(numberTwo);
                            break;
                        case "*":
                            result = numberOne * numberTwo;
                            firstNumber = String.valueOf(numberOne);
                            break;
                        case "/":
                            result = numberOne / numberTwo;
                            firstNumber = String.valueOf(numberOne);
                            break;

                    }
                    textView.setText(Double.toString(result));
//                    textView.setText(firstNumber);
                } catch (Exception e) {
                    textView.setText("err");
                }

            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    double numberOne = Double.parseDouble(firstNumber);
                    double numberTwo = Double.parseDouble((String) textView.getText());
                    double result = 0;
                    switch (mainSymbol) {
                        case "+":
                            result = numberOne + (numberOne * numberTwo / 100);
                            firstNumber = String.valueOf(numberOne);
                            break;
                        case "-":
                            result = numberOne - (numberOne * numberTwo / 100);
                            firstNumber = String.valueOf(numberOne);
                            break;
                        case "*":
                            result = numberOne * (numberOne * numberTwo / 100);
                            firstNumber = String.valueOf(numberOne);
                            break;
                        case "/":
                            result = numberOne / (numberOne * numberTwo / 100);
                            firstNumber = String.valueOf(numberOne);
                            break;

                    }
                    textView2.setText(numberTwo + "%");
                    textView5.setText("=");
                    textView.setText(Double.toString(result));
                } catch (Exception e) {
                    textView.setText("err");
                }
            }
        });
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String s = (String) textView.getText();
                if (s.isEmpty() || s.equals("0"))
                    return;
                if (s.charAt(0) != '-')
                    textView.setText("-" + s);
                else if (s.charAt(0) != '+')
                    textView.setText(removeFirstChar(s));
//                else if (s.charAt(0) == '+')
//                    textView.setText(removeFirstChar(s));
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
                textView2.setText("");
                textView3.setText("");
                textView4.setText("");
                textView5.setText("");
            }
        });
    }

    //operation button
    public void onClickOperationButton(Button buttonLocal, String symbol) {
        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String result;
                textView2.setText("");
                try {
                    result = (String) textView.getText();
                    try {
                        char s = result.charAt(result.length() - 1);
                        if (s == '+' || s == '-' || s == '/' || s == '*' || s == '%')
                            return;
                        firstNumber = result;
                        if (result.isEmpty())
                            textView4.setText(textView2.getText());
                        else
                            textView4.setText(result);
                        mainSymbol = symbol;
                        textView3.setText(mainSymbol);
                        result = symbol;
                    } catch (Exception e) {
                        result = "";
                    }
                } catch (Exception e) {
                    result = "";
                }
                textView.setText(result);
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
                    if (result.charAt(0) == '0') {
                        result = "";
                        textView.setText("1");
                    }
                    try {
                        char s = result.charAt(result.length() - 1);
                        if (s == '+' || s == '-' || s == '/' || s == '*' || s == '%')
                            result = "";
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                    result = "";
                }
                result += symbol;
                textView.setText(result);
            }
        });
    }

    public static String removeFirstChar(String s) {
        return (s == null || s.length() == 0) ? "" : (s.substring(1));
    }


}