package com.example.combaweiymq2019703;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.adapter.MyViewPagerFrag;
import com.example.bean.MyTabBean;
import com.example.fragment.MyFragment01;
import com.example.fragment.MyFragment02;
import com.example.fragment.MyFragment03;
import com.example.fragment.MyFragment04;
import com.example.until.Until;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private TabLayout tab;
    private ViewPager view_pager;
    private DrawerLayout draw;
    private Button btn_open;
    //private Until until = Until.getUntil();
    private ImageView img_view,img_picture;
    private ArrayList<Fragment> flist = new ArrayList<>();
    private String s="http://blog.zhaoliang5156.cn/zixunnew/categories";
    private ArrayList<MyTabBean> clist = new ArrayList<>();

    @Override
    protected void initClick() {
        img_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.openDrawer(Gravity.LEFT);
            }
        });
        img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,11);
            }
        });
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CAMERA_BUTTON);
                startActivityForResult(intent,22);
            }
        });
    }

    @Override

    protected void initData() {
        flist.add(new MyFragment01());
        flist.add(new MyFragment02());
        flist.add(new MyFragment03());
        flist.add(new MyFragment04());
    }
    //初始化控件
    @Override
    protected void initView() {
        draw = findViewById(R.id.draw);
        btn_open = findViewById(R.id.btn_open);
        tab = findViewById(R.id.tab);
        view_pager = findViewById(R.id.view_pager);
        img_picture = findViewById(R.id.img_picture);
        img_view = findViewById(R.id.img_view);
    }
    //解析标题
    @Override
    protected void initUser() {
        boolean isNetWork = Until.IsNetWork(this);
        if (isNetWork==true){
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        }
        Until.AsnycTaskString(s, new Until.CallTaskString() {
            @Override
            public void StringSS(String s) {
                Gson gson = new Gson();
                MyTabBean resultBean = gson.fromJson(s, MyTabBean.class);
                List<MyTabBean.ResultBean> result = resultBean.getResult();
                Log.i("aaa", "StringSS: "+result.toString());
                //viewpager与tablayout
                 initData();
                MyViewPagerFrag viewPagerFrag = new MyViewPagerFrag(getSupportFragmentManager(), flist);
                view_pager.setAdapter(viewPagerFrag);
                for (int i = 0; i < result.size(); i++) {
                    tab.addTab(tab.newTab());
                }
                tab.setupWithViewPager(view_pager);

                for (int i = 0; i <result.size() ; i++) {
                    String title = result.get(i).getTitle();
                    tab.getTabAt(i).setText(title);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11&data!=null){
            Uri uri = data.getData();
            img_view.setImageURI(uri);
            Glide.with(MainActivity.this).load(uri).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(img_view);
        }
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_base;
    }
}
