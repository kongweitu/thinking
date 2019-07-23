package com.boot.thinking.annotion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private String address;
    private Integer age;
}
