package com.firstmeet.loadingdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.show).setOnClickListener(v -> {
            if (loadingDialog == null) {
                //创建
                loadingDialog = new LoadingDialog(MainActivity.this, "正在加载", R.drawable.anim_loading);
            }
            //调用
            loadingDialog.show();
        });
    }
}