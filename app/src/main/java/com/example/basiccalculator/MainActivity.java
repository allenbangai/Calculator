package com.example.basiccalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView one, two, three, four, five, six, seven, answer, editText,
            eight, nine, zero, plus ,minus, multiply, divide, dot, equals;
    Button clear, delete;
    private String concatString;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.text_one);
        two = findViewById(R.id.text_two);
        three = findViewById(R.id.text_three);
        four = findViewById(R.id.text_four);
        five = findViewById(R.id.text_five);
        six = findViewById(R.id.text_six);
        seven = findViewById(R.id.text_seven);
        eight = findViewById(R.id.text_eight);
        nine = findViewById(R.id.text_nine);
        zero = findViewById(R.id.text_zero);
        answer = findViewById(R.id.answer);
        plus = findViewById(R.id.text_addition);
        minus = findViewById(R.id.text_substraction);
        multiply = findViewById(R.id.text_multiplication);
        divide = findViewById(R.id.text_division);
        dot = findViewById(R.id.text_dot);
        equals = findViewById(R.id.text_equal);
        editText = findViewById(R.id.editText);

        clear = findViewById(R.id.text_clear);
        delete = findViewById(R.id.text_delete);

        TextView[] textViews = new TextView[]{one, two, three, four, five, six, seven, answer,
            eight, nine, zero, plus ,minus, multiply, divide, dot, equals, editText};

        for (TextView a : textViews){
            a.setOnClickListener(this);
        }

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                answer.setText("");
                stringAnswer="";    firstNumString = "";    current_operator = "";
                firstNum = 0.0;     tempNum = 0.0;       resultNum = 0.0;
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numLength = firstNumString.length();
                if(numLength>0){
                    firstNumString = firstNumString.substring(0, numLength-1);
                    firstNum = Double.parseDouble(firstNumString);
                }
                onDoOperation();
                concatString = editText.getText().toString();
                int string_length = concatString.length();
                if(string_length > 0){
                    concatString = concatString.substring(0, string_length-1);
                    editText.setText(concatString);
                }
            }
        });
    }

    double firstNum = 0.0, tempNum = 0.0, resultNum = 0.0, answerNum = 0.0;
    int increment = 1, anInt = 1;
    double[] values = new double[increment];
    String stringAnswer="", firstNumString = "", current_operator = "";

    public void onClickNumber(View v){
        TextView t_View = (TextView)v;
        firstNumString += t_View.getText().toString();
        Toast.makeText(this, firstNumString, Toast.LENGTH_SHORT).show();
        firstNum = Double.parseDouble(firstNumString);
        onDoOperation();
    }

    public void onDoOperation(){
        switch (current_operator){
            case ""://if operator is null
                tempNum = resultNum +firstNum;
                stringAnswer = Double.toString(tempNum);
                Toast.makeText(this,"no way"+stringAnswer, Toast.LENGTH_SHORT).show();
                answer.setText(stringAnswer);
                break;
            case "+"://if operator is plus(+)
                tempNum = resultNum + firstNum;
                stringAnswer = Double.toString(tempNum);

                Toast.makeText(this,"+"+stringAnswer, Toast.LENGTH_SHORT).show();
                break;
            case "-"://if operator is minus(-)
                tempNum = resultNum -firstNum;
                stringAnswer = Double.toString(tempNum);
                break;
            case "*"://if operator is multiplication(*)
                tempNum = resultNum *firstNum;
                stringAnswer = Double.toString(tempNum);
                break;
            case "/"://if operator is division(/)
                try {
                    tempNum = resultNum /firstNum;
                    stringAnswer = Double.toString(tempNum);
                }catch (Exception e){
                    e.getMessage();
                }
                break;
        }
        //update the calculation to the textView for answer
        updateCalculation();
    }

    public void onClickOperator(View v){
        TextView view_operator = (TextView)v;
        //if answer is null meaning no calculations needed
        current_operator = view_operator.getText().toString();
        if(stringAnswer != ""){
            firstNumString = "";
            firstNum = 0.0;
            resultNum = tempNum;
            tempNum = 0.0;
            stringAnswer = Double.toString(resultNum);
            Toast.makeText(this,stringAnswer, Toast.LENGTH_SHORT).show();
            updateCalculation();
        }
    }

    private void updateCalculation() {
        answer.setText(stringAnswer);
    }

    public String getConcatString(String value01, String value02) {
        return value01 + value02;
    }

    public void compute(TextView textView){
        String[] digit = new String[2];
        int i;

        if(textView == one){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == two){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == three){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == four){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == five){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == six){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == seven){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == eight){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == nine){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }else if(textView == zero){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickNumber(textView);

        }
        else if(textView == plus){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickOperator(textView);

        }else if(textView == minus){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickOperator(textView);

        }else if(textView == multiply){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            onClickOperator(textView);

        }else if(textView == divide){
            i = 0;
            digit[i] = editText.getText().toString();
            i++;
            digit[i] = textView.getText().toString();

            editText.setText(getConcatString(digit[0], digit[1]));
            current_operator = textView.getText().toString();
            onClickOperator(textView);

        }else if(textView == equals){

        }
        else {

        }
    }

    @Override
    public void onClick(View v) {
        compute((TextView) v);

    }

}
