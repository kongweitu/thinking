package com.boot.thinking.enable;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String,Object> annotionAttrbutes = annotationMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.Type type = (Server.Type)annotionAttrbutes.get("type");
        String[] importClassNames = new String[0];
        switch (type){
            case HTTP:
                importClassNames= new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames= new String[]{FtpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}
