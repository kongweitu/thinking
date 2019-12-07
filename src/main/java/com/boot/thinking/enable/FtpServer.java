package com.boot.thinking.enable;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("ftp 开始");
    }

    @Override
    public void stop() {
        System.out.println("ftp 结束");

    }
}
