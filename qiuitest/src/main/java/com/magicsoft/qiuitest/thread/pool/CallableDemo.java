package com.magicsoft.qiuitest.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/24
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("CallableDemo is Running");
        return "Hello Callable";
    }


    public static void main(String[] args) {
        //1,创建接口实现类的示例
        CallableDemo callableDemo = new CallableDemo();
        // 2. 将 Callable 的实现类实例传入 FutureTask(Callable<V> callable) 构造方法中创建 FutureTask 实例。
        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo);
        // 3. 将 FutureTask 实例传入 Thread(Runnable r) 构造方法中创建 Thread 实例。
        Thread thread = new Thread(stringFutureTask);

        //4,调用start()方法
        thread.start();

        //5,调用FutureTask对象,获取返回值
        try {
            String callback = stringFutureTask.get();
            System.out.println(callback);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
