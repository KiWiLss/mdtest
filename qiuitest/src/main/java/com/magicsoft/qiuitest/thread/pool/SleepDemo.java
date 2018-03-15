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


public class SleepDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            System.out.println(i);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
