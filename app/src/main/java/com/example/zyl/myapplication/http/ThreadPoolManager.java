package com.example.zyl.myapplication.http;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyinglong on 2017/11/7.
 * 任务管理中心
 */

public final class ThreadPoolManager {

    private final String TAG = ThreadPoolManager.class.getSimpleName();

    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(); //队列

    private ThreadPoolExecutor mPoolExecutor;

    private ThreadPoolManager() {

        mPoolExecutor = new ThreadPoolExecutor(
                4, 20, 6000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), handler) {

        };

        mPoolExecutor.execute(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    mPoolExecutor.execute(task);
                }
            }
        }
    };


    private static ThreadPoolManager instance;


    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            instance = new ThreadPoolManager();
        }
        return instance;
    }

    /**
     * 执行任务
     */
    protected void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                queue.put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
