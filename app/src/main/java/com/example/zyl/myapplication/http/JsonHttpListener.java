package com.example.zyl.myapplication.http;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by zhaoyinglong on 2017/11/7.
 */

public class JsonHttpListener implements IHttpListener {

    private IDataListener mListener;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public JsonHttpListener(IDataListener listener) {
        mListener = listener;
    }

    @Override
    public void success(final String is) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onSuccess(is);
            }
        });
    }

    @Override
    public void failed(final String message) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailed(message);
            }
        });
    }
}
