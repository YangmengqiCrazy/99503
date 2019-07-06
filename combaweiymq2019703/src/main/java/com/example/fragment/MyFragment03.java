package com.example.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.combaweiymq2019703.MainActivity;
import com.example.combaweiymq2019703.R;

public class MyFragment03 extends Fragment {
    private View view;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.frag03, container, false);
         img = view.findViewById(R.id.img);
            initclick();
         return view;
    }

    private void initclick() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,11);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11&data!=null){
            Uri uri = data.getData();
            img.setImageURI(uri);
            Glide.with(getActivity()).load(uri).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(img);
        }
    }
}
