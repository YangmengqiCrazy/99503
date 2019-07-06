package com.example.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.combaweiymq2019703.R;

public class MyFragment02 extends Fragment {
    private View view;
    private WebView webview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.frag02, container, false);
        webview = view.findViewById(R.id.webview);
        initView();
        return view;
    }


    private void initView() {
        webview.loadUrl("http://blog.zhaoliang5156.cn/zixunnew/categories");
        //ss
    }
}