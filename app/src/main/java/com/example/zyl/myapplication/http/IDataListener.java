package com.example.zyl.myapplication.http;

/**
 * Created by zhaoyinglong on 2017/11/7.
 */

public interface IDataListener {
    void onSuccess(String is);
    void onFailed(String message);
}
