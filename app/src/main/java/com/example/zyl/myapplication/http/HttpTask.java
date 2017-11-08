package com.example.zyl.myapplication.http;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhaoyinglong on 2017/11/7.
 * 一个请求的task
 */

public class HttpTask<T> implements Runnable {


    private IHttpListener mHttpListener;
    private IHttpService mService;

    protected HttpTask(String url, T requestInfo, IHttpListener httpListener, IHttpService service) {

        mHttpListener = httpListener;
        mService = service;

        mService.setURl(url);
        mService.setHttpCallBack(mHttpListener);
        if (requestInfo !=null){
            String requsetContent = JSON.toJSONString(requestInfo);
            try {
                mService.setRequestData(requsetContent.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送真是的网络请求
     */
    @Override
    public void run() {
        mService.execute();
    }
}
