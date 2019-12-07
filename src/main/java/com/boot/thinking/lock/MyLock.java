package com.boot.thinking.lock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyLock {

    int a =0;
    public void increase(){
        a++;
    }

    public static void main(String[] args) {
         MyLock myLock = new MyLock();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    for (int j = 0; j < 1000; j++) {
                        myLock.increase();
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myLock.a);
    }




}
