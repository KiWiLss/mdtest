package com.magicsoft.deep.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/2/8
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class CallBackDemo implements Callable<String>{
    // 1. 创建一个类实现 Callable 接口，并重写 call() 方法。
    @Override
    public String call() throws Exception {
        System.out.println("CallableDemo is Running"+System.currentTimeMillis());
        return "Hello Callable";
    }

    public static void main(String[] args) {

        CallBackDemo callBackDemo = new CallBackDemo();

        // 3. 将 Callable 的实现类实例传入 FutureTask(Callable<V> callable) 构造方法中创建 FutureTask 实例。
        FutureTask<String> futureTask = new FutureTask<>(callBackDemo);

        // 4. 将 FutureTask 实例传入 Thread(Runnable r) 构造方法中创建 Thread 实例。
        Thread thread = new Thread(futureTask);
// 5. 调用该 Thread 线程对象的 start() 方法。
        thread.start();

        // 6. 调用 FutureTask 实例对象的 get() 方法获取返回值。
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
