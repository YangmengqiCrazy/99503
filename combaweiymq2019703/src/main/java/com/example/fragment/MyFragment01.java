package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.adapter.MyLIstAdapter;
import com.example.bean.MyViewBean;
import com.example.combaweiymq2019703.R;
import com.example.until.Until;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyFragment01 extends Fragment {
    private View view;
    private Banner banner;
    private PullToRefreshListView ptflist_view;
    private String s="http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1";
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.frag01, container, false);
        ptflist_view = view.findViewById(R.id.ptflist_view);
        banner = view.findViewById(R.id.banner);
        initUser();
        return view;
    }

    private void initUser() {
        Until.AsnycTaskString(s, new Until.CallTaskString() {
            @Override
            public void StringSS(String s) {
                Gson gson = new Gson();
                MyViewBean myViewBean = gson.fromJson(s, MyViewBean.class);
                List<MyViewBean.DataBean.NewsBean> news = myViewBean.getData().getNews();
                Log.i("aaa", "StringSS: "+news);
                banner.setImages(news);
                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        MyViewBean.DataBean.NewsBean bean = (MyViewBean.DataBean.NewsBean) path;
                        String imageUrl = bean.getImageUrl();
                        Glide.with(getActivity()).load("http://blog.zhaoliang5156.cn/zixunnew/"+imageUrl).into(imageView);
                    }
                });
                banner.isAutoPlay(true);
                banner.setDelayTime(2000);
                banner.start();
                MyLIstAdapter myLIstAdapter = new MyLIstAdapter((ArrayList<MyViewBean.DataBean.NewsBean>) news, getActivity());
                ptflist_view.setAdapter(myLIstAdapter);
                ptflist_view.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                        page = 1;
                        ptflist_view.getRefreshableView();
                        pullToRefreshBase.isPullToRefreshEnabled();
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                        page +=1;
                        ptflist_view.getRefreshableView();
                        pullToRefreshBase.isRefreshing();

                    }
                });
            }
        });
    }
}
