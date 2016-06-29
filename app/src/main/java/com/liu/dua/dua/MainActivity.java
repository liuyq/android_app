package com.liu.dua.dua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void number(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message);
        if(textView != null) {
            textView.setText("" + count++);
            textView.setOnLongClickListener(null);
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }

    public void randomNumber(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message);
        if(textView != null) {
            textView.setText("" + r.nextInt(100));
            textView.setOnLongClickListener(null);
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }

    public void mathIn100(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message);
        if(textView != null) {
            boolean isAddition = r.nextBoolean();
            int operand1 = r.nextInt(100);
            String output = "";
            int result = 0;
            if (isAddition) {
                int operand2 = r.nextInt(100 - operand1);
                output = operand1 + " + " + operand2 + " = ";
                result = operand1 + operand2;
            } else {
                int operand2 = operand1 == 0 ? 0 : r.nextInt(operand1);
                output = operand1 + " - " + operand2 + " = ";
                result = operand1 - operand2;
            }
            textView.setText(output + "?");
            textView.setHint(result + "");
            final String finalOutput = output;
            final int finalResult = result;
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), finalOutput + finalResult, Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }

    public void additionIn20(View view) {
        TextView textView = (TextView) findViewById(R.id.show_message);
        int scope = 10;
        if(textView != null) {
            //boolean isAddition = r.nextBoolean();
            boolean isAddition = true;
            int operand1 = r.nextInt(scope);
            String output = "";
            int result = 0;
            if (isAddition) {
                int operand2 = r.nextInt(scope);
                output = operand1 + " + " + operand2 + " = ";
                result = operand1 + operand2;
            } else {
                int operand2 = operand1 == 0 ? 0 : r.nextInt(operand1);
                output = operand1 + " - " + operand2 + " = ";
                result = operand1 - operand2;
            }
            textView.setText(output + "?");
            textView.setHint(result + "");
            final String finalOutput = output;
            final int finalResult = result;
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), finalOutput + finalResult, Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }else{
            Log.e("LIUYQ", "Show message component not found");
        }
    }
}
