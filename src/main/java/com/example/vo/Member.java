package com.example.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//main/java
//여기까지가 기본

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Member {
    // 1. 변수
    private String Id = null;
    private String name = null;
    private String role = null;
    private int age = 999;
    private String regdate = null;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Member [Id=" + Id + ", age=" + age + ", name=" + name + ", regdate=" + regdate + ", role=" + role + "]";
    }

}
