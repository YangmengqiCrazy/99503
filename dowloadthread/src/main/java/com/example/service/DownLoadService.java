package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.example.entities.FileInfo;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoadService extends Service {
    public  static  final  String ACTION_START = "ACTION_START";
    public  static  final  String ACTION_STOP = "ACTION_STOP";
    public static final  String DOWNLOAD_PATH=Environment.getExternalStorageDirectory().getAbsolutePath()+"/downloads/";
    public static final int MSG= 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case  MSG:
                    FileInfo fileInfo = (FileInfo) msg.obj;
                    Log.i("aaa", "handleMessage: "+fileInfo);
                    break;
            }
        }
    };
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       //获得activity 传来的参念书
        if (ACTION_START.equals(intent.getAction())){
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            Log.i("aaa", "开始下载 "+fileInfo.toString());
        }else  if (ACTION_STOP.equals(intent.getAction())){
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            Log.i("aaa", "停止下载"+fileInfo.toString());
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class InitThread extends Thread{
        private FileInfo fileInfo = null;

        public InitThread(FileInfo fileInfo) {
            this.fileInfo = fileInfo;
        }

        @Override
        public void run() {
            super.run();
            HttpURLConnection connection = null;
            //连接网络文件
            try {
                URL url = new URL(fileInfo.getUrl());
                //网络请求
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(3000);
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                int length = -1;
                if (responseCode == 200){
                    length = connection.getContentLength();
                }
                if (length<=0){
                    return;
                }
                File patha = new File(DOWNLOAD_PATH);
                if (patha.exists()){
                    //创建文件夹
                    patha.mkdir();
                }
                File file = new File(patha, fileInfo.getFileName());
                RandomAccessFile ran= new RandomAccessFile(file,"rwd");
                //设置长度
                ran.setLength(length);
                fileInfo.setLength(length);
                handler.obtainMessage(MSG,fileInfo).sendToTarget();

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                connection.disconnect();

            }
            //获得文件长度
        }
    }
}
