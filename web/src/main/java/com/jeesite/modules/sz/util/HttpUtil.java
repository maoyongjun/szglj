package com.jeesite.modules.sz.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

    static URLConnection openConn(String urlk) throws MalformedURLException, IOException {

        URL url = new URL(urlk);
        HttpURLConnection hsu = (HttpURLConnection) url.openConnection();
        hsu.setDoInput(true);
        hsu.setDoOutput(true);
        hsu.setRequestMethod("GET");
        return hsu;

    }

    static void closeConn(HttpURLConnection c) {
        c.disconnect();
    }

    //get请求
    public static String HttpURLConnectionGet(String requestUrl) {
        HttpURLConnection httpURLConnection = null;
        InputStream is = null;
        //StringBuilder:线程非安全，可有多线程采用，速度比StingBuffer快,用法同StringBuffer
        // StringBuffer:线程安全，只能单线程采用
        StringBuilder sb = new StringBuilder();
        try {
            //准备请求的网络地址
            URL url = new URL(requestUrl);
            //调用openConnection得到网络连接，网络连接处于就绪状态
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置网络连接超时时间5S
            httpURLConnection.setConnectTimeout(5*1000);
            //设置读取超时时间
            httpURLConnection.setReadTimeout(5*1000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("apikey","58218dcc8845195b277082c3a357f481");
            httpURLConnection.connect();
            //if连接请求码成功
            if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK){
                is = httpURLConnection.getInputStream();
                byte[] bytes = new byte[1024];
                int i = 0;
                while ((i = is.read(bytes)) != -1){
                    sb.append(new String(bytes,0,i,"utf-8"));
                }
                is.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return sb.toString();
    }
}
