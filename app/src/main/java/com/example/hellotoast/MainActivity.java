package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mButtonZero = (Button)findViewById(R.id.button_zero);
        setColor(findViewById(R.id.button_count), mCount % 2 == 0 ? Color.RED : R.color.green);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mButtonZero.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            if(mCount%2 == 0){
                view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            else{
                view.setBackgroundColor(getResources().getColor(R.color.green));
            }
            mShowCount.setText(Integer.toString(mCount));

            setColor(view, mCount % 2 == 0 ? Color.RED : R.color.green);
            setColor(findViewById(R.id.button_zero), Color.BLACK);
        }
    }

    public void countZero(View view) {
        mCount = 0;
        mShowCount.setText("0");

        setColor(view, Color.parseColor("#ffaaaaaa"));
        setColor(findViewById(R.id.button_count), Color.RED);
    }
    private void setColor(View view, int color)
    {
        view.setBackgroundColor(color);
    }
}