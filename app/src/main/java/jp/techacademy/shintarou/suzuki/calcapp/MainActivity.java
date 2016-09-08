package jp.techacademy.shintarou.suzuki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText edit1;
    EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button)findViewById(R.id.add);//＋ボタン
        Button sub = (Button)findViewById(R.id.sub);//－ボタン
        Button mul = (Button)findViewById(R.id.mul);//×ボタン
        Button div = (Button)findViewById(R.id.div);//÷ボタン
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
    }

    public void onClick(View view)
    {
        int keisan = 0;
        Intent intent = new Intent(this, CalcResult.class);
        if(view.getId() == R.id.add)
        {
            keisan = 1;
        }
        else if(view.getId() == R.id.sub)
        {
            keisan = 2;
        }
        else if(view.getId() == R.id.mul)
        {
            keisan = 3;
        }
        else if(view.getId() == R.id.div)
        {
            keisan = 4;
        }
        else
        {
            // none
        }
        intent.putExtra("value1", Double.parseDouble(edit1.getText().toString()));
        intent.putExtra("value2", Double.parseDouble(edit2.getText().toString()));
        intent.putExtra("keisan", keisan);

        startActivity(intent);//2画面目を呼ぶ

    }
}
