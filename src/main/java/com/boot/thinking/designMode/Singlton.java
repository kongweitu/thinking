package com.boot.thinking.designMode;

public class Singlton {
    private static volatile  Singlton singlton=null;
    private Singlton(){};
    public static Singlton getInstance(){
        if (singlton==null){
            synchronized(Singlton.class){
                if (singlton==null){
                    singlton= new Singlton();
                }
            }
        }
        return singlton;
    }
}
