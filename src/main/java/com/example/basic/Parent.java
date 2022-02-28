package com.example.basic;

public abstract class Parent {

    // 클래스의 공통변수
    private int num = 0;

    // 클래스명과 일치하는 것 > 생성자 , 여러개 가능(오브로딩)
    public Parent() {

    }

    // 생성자
    public Parent(int num) {
        this.num = num;
    }

    public void printNum() {
        System.out.println(this.num);
        // 1 2 3 4 5 6 7 8 9
        // 너무 많이 조립해서 주면 개조해서 쓰기가 어려움
        // 자유로움을 줌
    }

    // 메소드는 기능구현x, 이렇게 부모가 기능을 구현하지 않아. 자식아 가져가서 일을 해야해
    // ★자식은 반드시 기능을 구현해야 함.
    // 설계용. 이런 게 하나라도 존재한다면 클래스 앞에 abstract라고(추상화) 명시해야한다.
    public abstract void printNum1();

}

// 상속이란 누군가의 클래스를 개조해서 쓰고싶을 때 쓰는 것
// 무수히 많은 기능을 쓰고 싶다.