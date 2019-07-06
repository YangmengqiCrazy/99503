package com.example.combaweiymq2019703;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initUser();
        initView();
        initData();
        initClick();
    }

    protected abstract void initClick();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initUser();

    protected abstract int initLayout();
}
