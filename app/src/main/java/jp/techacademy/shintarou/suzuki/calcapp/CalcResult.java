package jp.techacademy.shintarou.suzuki.calcapp;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalcResult extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("value1", 0.0);
        double value2 = intent.getDoubleExtra("value2", 0.0);
        int keisan = intent.getIntExtra("keisan", 0);

        TextView text = (TextView)findViewById(R.id.result1);
        switch(keisan)
        {
            case 1:     //+
                text.setText(String.valueOf(value1 + value2));
                break;
            case 2:     //-
                text.setText(String.valueOf(value1 - value2));
                break;
            case 3:     //*
                text.setText(String.valueOf(value1 * value2));
                break;
            case 4:     // /
                if(value2 == 0)
                {
                    text.setText(String.valueOf("0で割れません。"));
                }
                else
                {
                    text.setText(String.valueOf(value1 / value2));
                }
                break;
            default:
                break;
        }
    }
}
