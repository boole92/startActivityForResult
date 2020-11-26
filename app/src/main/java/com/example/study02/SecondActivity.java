package com.example.study02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //이 액티비티를 실행한 인텐트받기.
        Intent intent = getIntent();

        //인텐트에 담아놓은 데이터 뽑기.
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");

//      mResultText를 인텐트에 담기위해 필드로 설정
        mResultText = findViewById(R.id .resultText);
        mResultText.setText(name +" " + age + "살");

        findViewById(R.id.button_result).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", mResultText.getText().toString());

        //결과 전송 메소드.
        //startActivityForResult로 보낸거기 때문에 보낸곳으로 다시 보내는 것임.

        setResult(RESULT_OK, intent);

        //액티비티 종료 메소드.
        finish();
    }
}