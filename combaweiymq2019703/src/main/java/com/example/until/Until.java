package com.example.until;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Until {
    //单利模式
    private static  Until until = new Until();
    private static ConnectivityManager service;
    private static NetworkInfo activeNetworkInfo;
    private static InputStream inputStream;
    private static HttpURLConnection httpURLConnection;

    public Until(){

    }
    public static Until getUntil(){
        return until;
    }
    //网络判断
    public static boolean IsNetWork(Context context){
        if (context!=null){
            service = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            activeNetworkInfo = service.getActiveNetworkInfo();
            if (activeNetworkInfo!=null){
                activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }
    //获取文字的工具类
   public static String GetString(String s){
       try {
           URL url = new URL(s);
           httpURLConnection = (HttpURLConnection) url.openConnection();
           httpURLConnection.setRequestMethod("GET");
           httpURLConnection.setReadTimeout(3000);
           httpURLConnection.setConnectTimeout(3000);
           int responseCode = httpURLConnection.getResponseCode();
           if (responseCode == 200){
               InputStream inputStream = httpURLConnection.getInputStream();
               BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
               String str="";
               StringBuilder builder = new StringBuilder();
               while ((str = reader.readLine())!=null){
                   builder.append(str);
               }
               return builder.toString();   
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
       httpURLConnection.disconnect();
       return "";
   }
   //接口
    public interface CallTaskString{
        void StringSS(String s);
    }
    //异步任务
    public static void AsnycTaskString(String s,final CallTaskString callTaskString){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return GetString(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                callTaskString.StringSS(s);
            }
        }.execute(s);
    }
    //图片解析
    public static Bitmap GetImage(String s){
        Bitmap bitmap = null;
        try {
            URL url = new URL(s);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(3000);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200){
                InputStream inputStream = httpURLConnection.getInputStream();
               bitmap = BitmapFactory.decodeStream(inputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        httpURLConnection.disconnect();
        return bitmap;
    }

    //接口
    public interface CallTaskImage{
        void Imagess(Bitmap s);
    }

    //异步图片
    public static void AsnycTaskImage(String s,final CallTaskImage callTaskImage){
        new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                return GetImage(strings[0]);
            }

            @Override
            protected void onPostExecute(Bitmap s) {
                callTaskImage.Imagess(s);
            }
        }.execute(s);
    }


}
