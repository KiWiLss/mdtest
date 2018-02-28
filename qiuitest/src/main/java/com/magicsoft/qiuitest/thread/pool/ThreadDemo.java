package com.magicsoft.qiuitest.thread.pool;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/24
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class ThreadDemo extends Thread{


    @Override
    public void run() {
       // super.run();
        System.out.println("Hello Thread");
    }

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.start();

        System.out.println(threadDemo.getPriority());

    }
}
