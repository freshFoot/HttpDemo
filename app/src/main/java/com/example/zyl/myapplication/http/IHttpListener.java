package com.example.zyl.myapplication.http;

/**
 * Created by zhaoyinglong on 2017/11/7.
 */

public interface IHttpListener {

    void success(String is);

    void failed(String message);
}
