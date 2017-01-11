package com.example.prerit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity  {

    Button add,sub,div,multi;
    TextView result;
    EditText num1,num2;
    int x,y,z;
    int[] p = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.number1);
        num2=(EditText) findViewById(R.id.number2);
        result= (TextView) findViewById(R.id.textView3);
        add= (Button) findViewById(R.id.button);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    x = Integer.parseInt(num1.getText().toString());
                    y = Integer.parseInt(num2.getText().toString());
                    z = x + y;
                    result.setText(Integer.toString(z));
                }
                catch (Exception ex)
                {
                    result.setText("entetr a value");
                }
            }
        });
        div= (Button) findViewById(R.id.div);
        multi= (Button) findViewById(R.id.button4);
        sub= (Button) findViewById(R.id.sub);

        div.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                x=Integer.parseInt(num1.getText().toString());
                y=Integer.parseInt(num2.getText().toString());
                if(x==0 || y==0)
                {
                    result.setText("zero error");
                }
                else if (x>y)
                {
                    z=x/y;
                    result.setText(Integer.toString(z));
                }
                else
                {
                   z=y/x;
                    result.setText(Integer.toString(z));
                }
                }
                catch(Exception ex)
                {
                    result.setText(ex.toString());
                }

            }
        });
        sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    x = Integer.parseInt(num1.getText().toString());
                    y = Integer.parseInt(num2.getText().toString());
                    if (x > y) {
                        z = x - y;
                    } else {
                        z = y - x;
                    }
                    result.setText(Integer.toString(z));
                }
                catch (Exception ex)
                {
                    result.setText("entetr a value");
                }
            }
        });
        multi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    x = Integer.parseInt(num1.getText().toString());
                    y = Integer.parseInt(num2.getText().toString());
                    z = x * y;
                    result.setText(Integer.toString(z));
                }
                catch (Exception ex)
                {
                    result.setText("entetr a value");
                }
            }
        });


    }
}
