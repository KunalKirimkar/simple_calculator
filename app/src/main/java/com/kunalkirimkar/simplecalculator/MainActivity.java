package com.kunalkirimkar.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mul, div, equal, percent, decimal, backSpace, allClear;
    private TextView inputView, resultView;
    private static final char ADDITION = '+', SUBTRACTION = '-', MULTIPLICATION = '*', DIVISION = '/', PERCENT = '%'; // EQUAL = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");
        setupViewIds();
        onClickListener();
    }

    private void setupViewIds() {
        inputView = findViewById(R.id.inputView);
        resultView = findViewById(R.id.resultView);
        one = findViewById(R.id.btn1);
        zero = findViewById(R.id.btn0);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        add = findViewById(R.id.btnAddition);
        sub = findViewById(R.id.btnSubtraction);
        mul = findViewById(R.id.btnMultiply);
        div = findViewById(R.id.btnDivide);
        equal = findViewById(R.id.btnEqual);
        percent = findViewById(R.id.btnPercent);
        decimal = findViewById(R.id.btnDecimal);
        backSpace = findViewById(R.id.btnBackSpace);
        allClear = findViewById(R.id.btnAllClear);
    }
    private void onClickListener() {
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "0" );
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "1" );
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "2" );
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "3" );
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "4" );
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "5" );
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "6" );
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "7" );
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "8" );
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText().toString() + "9" );
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = ADDITION;
                resultView.setText(decimalFormat.format(val1) + "+");
                inputView.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = SUBTRACTION;
                resultView.setText(decimalFormat.format(val1) + "-");
                inputView.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = MULTIPLICATION;
                resultView.setText(decimalFormat.format(val1) + "*");
                inputView.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                ACTION = DIVISION;
                resultView.setText(decimalFormat.format(val1) + "/");
                inputView.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                //ACTION = 0;
                //inputView.setText(inputView.getText().toString() + val1 + "=" + val2);
                resultView.setText(decimalFormat.format(val1));
                val1 = Double.NaN;
                ACTION = '0';

            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText(inputView.getText() + ".");
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTION = PERCENT;
                resultView.setText(decimalFormat.format(val1) + "%");
                inputView.setText(null);
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputView.getText().length() > 0){
                    CharSequence name = inputView.getText().toString();
                    inputView.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    inputView.setText(null);
                }
            }
        });

        allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputView.setText("0");
                resultView.setText("0");
            }
        });
    }
    private void calculate() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(inputView.getText().toString());
            inputView.setText(null);
            if (ACTION == ADDITION)
                val1 = this.val1 + val2;
            else if (ACTION == SUBTRACTION)
                val1 = this.val1 - val2;
            else if (ACTION == MULTIPLICATION)
                val1 = this.val1 * val2;
            else if (ACTION == DIVISION)
                val1 = this.val1 / val2;
            else if (ACTION == PERCENT)
                val1 = this.val1 % val2;
        } else {
            try {
                val1 = Double.parseDouble(inputView.getText().toString());
            } catch (Exception e) {}
        }
    }
}