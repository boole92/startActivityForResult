package com.example.study02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1000;
    private EditText mNameEditText;
    private EditText mAgeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = findViewById(R.id.edit_name);
        mAgeEditText = findViewById(R.id.edit_age);

        //변수 선언 없이, onClick 속성 없이 바로 setOnClick리스너 달기.
        //this에서 alt+enter치고 다시 한 번 엔터.
        //이 액티비티에서 onClick을 구현해주겠다.
        findViewById(R.id.button_send).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);

        //인텐트에 String 변수 없이 바로 담기.
        intent.putExtra("name", mNameEditText.getText().toString());
        intent.putExtra("age", mAgeEditText.getText().toString());

        //인텐트를 주고나서 결과를 다시 받을 수 있는 메소드.
        //리퀘스트 코드를 정해줘야함. 한글로 요청코드, 비밀번호 같은 개념.
        //리퀘스트 코드는 int 타입으로 숫자를 입력하면 되고 내 맘대로임.
        //ctrl+shift+C 로 상수화 시킬 수 있다.
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //여기서 결과로 넘어온 인텐트를 처리한다.
        //Intent 이름이 data로 되어있어서 상당히 헷갈림.
        //startActivityForResult 와 리퀘스트 코드가 맞아야 정상 작동함.
        super.onActivityResult(requestCode, resultCode, data);

        //resultCode는 결과가 성공적인지 아닌지를 확인함. RESULT_OK와 RESULT_CANCELED중에 하나가 들어옴.
        //RESULT_CANCELED 로 실패나 취소시 액션 따로 설정 가능.

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            //data가 오른쪽위에 이미 Intent타입이기 때문에 getStringExtra가 가능한거임.
            String result = data.getStringExtra("result");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
}

