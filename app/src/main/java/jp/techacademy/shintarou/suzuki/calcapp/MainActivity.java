package jp.techacademy.shintarou.suzuki.calcapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText edit1;
    EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
        String str1 = "";
        String str2 = "";
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

        str1 = edit1.getText().toString();
        str2 = edit2.getText().toString();

        /* 未入力箇所がある場合は計算をしない */
        if(str1.equals("") || str2.equals(""))
        {/*
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("ERROR");
            alertDialogBuilder.setView(new EditText(this));
            alertDialogBuilder.setMessage("数値が未入力です。");
            alertDialogBuilder.setPositiveButton("肯定",null);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
         */
            Toast.makeText(this, "未入力箇所があります。\n入力してください。", Toast.LENGTH_SHORT).show();
        }
        /* 2か所とも入力された場合は計算をする */
        else
        {
            intent.putExtra("value1", Double.parseDouble(edit1.getText().toString()));
            intent.putExtra("value2", Double.parseDouble(edit2.getText().toString()));
            intent.putExtra("keisan", keisan);

            startActivity(intent);//2画面目を呼ぶ
        }

    }
}
