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
    /*
    - Intent 는 실행할 인스턴스를 담는 봉투역할.
            - 실행은 startActivity(인텐트명);
    - 오버로드 Intent(출력할 위치this, 출력할 콘텐츠activity);
    - 오버로드 Intent(실행할 액션action_view, 파싱정보http:,tel:);
    - 안드로이드 액티비티 화면이동의 특징(아래-웹페이지이동과는 틀림)
    - 액티비티(화면)에서 다른 액티비티(화면) 호출한다고해서,
                - 기존 액티비티(화면)이 종료되는게 아닙니다.
                - 기존 액티비티(화면) 위쪽에 호출된 액티비티(화면)이 올라타는 구조
    - 그래서 서브액티비티에서 finish()메서드를 실행하면,
    - 현재 액티비티가 종료되고, 밑에 있던 메인액티비티가 나타납니다.
    */
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