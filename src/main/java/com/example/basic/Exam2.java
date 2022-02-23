package com.example.basic;

//public 공용(o)
// private 개인(x)

//클래스

public class Exam2 {
    // 객체를 직접 1개 만들기
    private static Exam2 obj = new Exam2();
    // 자기는 만들 수 있음

    // 안보이지만 생성자가 자동으로 이렇게 만들어져 있을거임
    // 생성자 private이기 때문에 외부에서 생성불가
    private Exam2() {

    }

    // 메소드
    // 원래 메소드는 객체가 생성되고 호출되는 것인데
    // static이 있으면 객체를 생성하지 않고 호출할 수 있음.
    public static Exam2 create() {
        return obj;
    }
}
