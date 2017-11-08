package com.example.zyl.myapplication.http;

/**
 * Created by zhaoyinglong on 2017/11/7.
 */

public class NetFrameWork {
    /**
     * @param requestInfo
     * @param url
     * @param listener
     * @param <T>
     */
    public static <T> void sendJsonRequest(T requestInfo, String url, IDataListener listener) {

        IHttpListener httplistener = new JsonHttpListener(listener);
        IHttpService service = new JsonHttpService();
        HttpTask httpTask = new HttpTask(url, requestInfo, httplistener, service);
        ThreadPoolManager.getInstance().execute(httpTask);
    }
}
