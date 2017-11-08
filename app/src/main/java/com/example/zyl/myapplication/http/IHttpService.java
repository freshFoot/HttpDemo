package com.example.zyl.myapplication.http;

/**
 * Created by zhaoyinglong on 2017/11/7.
 */

public interface IHttpService {

    void setRequestData(byte[] bytes);

    void setHttpCallBack(IHttpListener httpListener);

    void setURl(String url);

    void execute(); //发送真实的网络请求
}
