package com.boot.thinking.enable;

public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("http 启动");
    }

    @Override
    public void stop() {
        System.out.println("http 停止");

    }
}
