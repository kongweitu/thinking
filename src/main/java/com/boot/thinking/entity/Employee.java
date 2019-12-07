package com.boot.thinking.entity;

import lombok.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    private String name;
    private int salary;
    private String office;
    public byte[] toBytes(){
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bo);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            bo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bo.toByteArray();
    }
}
