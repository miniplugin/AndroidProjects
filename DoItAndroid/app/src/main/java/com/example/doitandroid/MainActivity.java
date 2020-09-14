package com.example.doitandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
}