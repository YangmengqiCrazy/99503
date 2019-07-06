package com.example.dowloadthread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.entities.FileInfo;
import com.example.service.DownLoadService;

public class MainActivity extends AppCompatActivity {
    private TextView tvFileName = null;
    private ProgressBar progress_bar = null;
    private Button btn_start = null;
    private Button btn_stop = null;
    private FileInfo fileInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fileInfo = new FileInfo(0,
                "https://dldir1.qq.com/music/clntupate/QQMusic_YQQProductNew.exe",
                "QQMusic_YQQProductNew.exe",0,0);
        onClick();

    }

    private void onClick() {
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过Intent传递参数Service
                Intent intent = new Intent(MainActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_STOP);
                intent.putExtra("fileInfo",fileInfo);
                startActivity(intent);
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过Intent传递参数Service
                Intent intent = new Intent(MainActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_START);
                intent.putExtra("fileInfo",fileInfo);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tvFileName =(TextView) findViewById(R.id.tvFileName);
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        btn_start =(Button) findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);
    }
}
