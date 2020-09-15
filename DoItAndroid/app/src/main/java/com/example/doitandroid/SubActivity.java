package com.example.doitandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void btnGoBack(View view) {
        Toast.makeText(this, "이전 화면으로 이동합니다.", Toast.LENGTH_LONG).show();
        finish();//화면을 종료합니다.
    }
}