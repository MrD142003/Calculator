package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnPlus, btnMin, btnTimes, btnDiv, btnEquals,
            btnOn, btnAc, btnDel, btnOff, btnPoint;

    TextView txtScreen;
    double firstNum;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitNum();
        InitBut();
        txtScreen = findViewById(R.id.screen);
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNum = 0;
                txtScreen.setText("0");
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setVisibility(View.GONE);
            }
        });

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setVisibility(View.VISIBLE);
                txtScreen.setText("0");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = txtScreen.getText().toString();
                if(num.length()>1)
                    txtScreen.setText(num.substring(0, num.length()-1));
                else if (num.length() == 1 && !num.equals("0"))
                    txtScreen.setText("0");

            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtScreen.getText().toString().contains("."))
                    txtScreen.setText(txtScreen.getText().toString() + ".");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double secondNum = Double.parseDouble(txtScreen.getText().toString());
                double result;
                switch (operation){
                    case "/":
                        result = firstNum/secondNum;
                        break;
                    case "X":
                        result = firstNum * secondNum;
                        break;
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    default:
                        result = firstNum + secondNum;
                }
                txtScreen.setText(String.valueOf(result));
                firstNum = result;
            }
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for (Button b : nums){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!txtScreen.getText().toString().equals("0"))
                        txtScreen.setText(txtScreen.getText().toString() + b.getText().toString());
                    else
                        txtScreen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(btnDiv);
        opers.add(btnTimes);
        opers.add(btnMin);
        opers.add(btnPlus);
        for (Button b : opers){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firstNum = Double.parseDouble(txtScreen.getText().toString());
                    operation = b.getText().toString();
                    txtScreen.setText("0");
                }
            });
        }
    }

    private void InitBut() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMin= findViewById(R.id.btnMin);
        btnTimes = findViewById(R.id.btnTimes);
        btnDiv = findViewById(R.id.btnDiv);
        btnEquals = findViewById(R.id.btnEqual);
        btnOn = findViewById(R.id.on);
        btnOff = findViewById(R.id.off);
        btnAc = findViewById(R.id.ac);
        btnDel = findViewById(R.id.btnDel);
        btnPoint = findViewById(R.id.btnPoint);
    }

    private void InitNum() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
}