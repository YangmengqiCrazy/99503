package com.example.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.MyViewBean;
import com.example.combaweiymq2019703.R;
import com.example.until.Until;

import java.util.ArrayList;

public class MyLIstAdapter extends BaseAdapter {
    private ArrayList<MyViewBean.DataBean.NewsBean> list;
    private Context context;

    public MyLIstAdapter(ArrayList<MyViewBean.DataBean.NewsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        switch (getItemViewType(position)){
            case 0:
                final ViewHolder holder;
                if (view == null){
                    view = View.inflate(context, R.layout.activity_main, null);
                    holder = new ViewHolder();
                    holder.img = view.findViewById(R.id.img);
                    holder.text_publishAt = view.findViewById(R.id.text_publishAt);
                    holder.text_title = view.findViewById(R.id.text_title);
                    view.setTag(holder);
                }else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.text_title.setText(list.get(position).getTitle());
                holder.text_publishAt.setText(list.get(position).getPublishAt());
                String imageUrl = list.get(position).getImageUrl();
                Until.AsnycTaskImage("http://blog.zhaoliang5156.cn/zixunnew/" + imageUrl, new Until.CallTaskImage() {
                    @Override
                    public void Imagess(Bitmap s) {
                        holder.img.setImageBitmap(s);
                    }
                });
                break;
            case 1:

                final ViewHolder01 holder01;
                if (view == null){
                    view = View.inflate(context, R.layout.activity_main01, null);
                    holder01 = new ViewHolder01();
                    holder01.img = view.findViewById(R.id.img);
                    holder01.text_publishAt = view.findViewById(R.id.text_publishAt);
                    holder01.text_title = view.findViewById(R.id.text_title);
                    view.setTag(holder01);
                }else {
                    holder01 = (ViewHolder01) view.getTag();
                }
                holder01.text_title.setText(list.get(position).getTitle());
                holder01.text_publishAt.setText(list.get(position).getPublishAt());
                String imageUrl01 = list.get(position).getImageUrl();
                Until.AsnycTaskImage("http://blog.zhaoliang5156.cn/zixunnew/" + imageUrl01, new Until.CallTaskImage() {
                    @Override
                    public void Imagess(Bitmap s) {
                        holder01.img.setImageBitmap(s);
                    }
                });
                break;
        }
        return view;
    }
    class ViewHolder{
        ImageView img;
        TextView text_title,text_publishAt;
    }
    class ViewHolder01{
        ImageView img;
        TextView text_title,text_publishAt;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
