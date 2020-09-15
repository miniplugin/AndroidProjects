package com.example.doitandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //화면에서 클릭 이벤트를 처리하는 2가지 방법중 2번째
        Button btn_app_login = (Button) findViewById(R.id.app_login);
        //특징: 온클릭 이벤트를 자바에서 시작한다.(아래 get/set사용)
        //리스너: 리슨(귀로 듣는다)상태(이벤트 대기상태)
        btn_app_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "방법2 로그인 성공", Toast.LENGTH_LONG).show();
            }
        });
    }
    //아래 코드는 화면에서 클릭 이벤트를 처리하는 2가지 방법중 1번째
    //특징: 온클릭 이벤트를 화면에서 시작한다.
    public void AppLogin(View view) {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show();
    }

    public void NaverGoUrl(View view) {
        Intent naverGoUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(naverGoUrl);
    }

    public void HpTel(View view) {
        Intent hpTel = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-0000-0000"));
        startActivity(hpTel);
    }

    public void NewActivity(View view) {
        Intent newActivity = new Intent(this, SubActivity.class);
        startActivity(newActivity);
    }
}