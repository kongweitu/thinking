package com.boot.thinking.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableServer(type=Server.Type.HTTP)
public class EnableServerBootStrp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableServerBootStrp.class);
        context.refresh();
        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }

}
