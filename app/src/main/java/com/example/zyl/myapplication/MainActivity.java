package com.example.zyl.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zyl.myapplication.http.IDataListener;
import com.example.zyl.myapplication.http.NetFrameWork;

public class MainActivity extends AppCompatActivity {

    String url = "https://www.baidu.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetFrameWork.sendJsonRequest("", url, new IDataListener() {
                    @Override
                    public void onSuccess(String is) {
                        Toast.makeText(MainActivity.this, "is:成功了" + is, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(MainActivity.this, "is:失败了" + message, Toast.LENGTH_SHORT).show();
                    }
                });
//                Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
