package com.boot.thinking.enable;

public interface Server {
    void start();

    void stop();
    public enum Type {
        HTTP,FTP
    }
}
