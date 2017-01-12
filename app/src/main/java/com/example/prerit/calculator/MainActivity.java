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
    int z;
    int[] p = new int[2];
    public void inputgetter()
    {
        try {
            p[0] = Integer.parseInt(num1.getText().toString());
            p[1] = Integer.parseInt(num2.getText().toString());
        }
        catch (Exception ex)
        {
            result.setText("entetr a value");
        }
    }
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
                    //x = Integer.parseInt(num1.getText().toString());
                   // y = Integer.parseInt(num2.getText().toString());
                    inputgetter();
                    z = p[0] + p[1];
                    result.setText(Integer.toString(z));


            }
        });
        div= (Button) findViewById(R.id.div);
        multi= (Button) findViewById(R.id.button4);
        sub= (Button) findViewById(R.id.sub);

        div.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               inputgetter();
                if(p[0]==0 || p[1]==0)
                {
                    result.setText("zero error");
                }
                else if (p[0]>p[1])
                {
                    z=p[0]/p[1];
                    result.setText(Integer.toString(z));
                }
                else
                {
                   z=p[1]/p[0];
                    result.setText(Integer.toString(z));
                }
                }

        });
        sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                     inputgetter();
                    if (p[0] > p[1]) {
                        z = p[0] - p[1];
                    } else {
                        z = p[1] - p[0];
                    }
                    result.setText(Integer.toString(z));
                }

        });
        multi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    inputgetter();
                    z = p[0] * p[1];
                    result.setText(Integer.toString(z));
                }

        });


    }
}
