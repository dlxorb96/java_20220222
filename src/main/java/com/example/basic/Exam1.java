package com.example.basic;

// 제너릭
public class Exam1<E> {
    // private int num = 0; // 숫자형
    private E name = null; // 타입이 없음.

    // namve을 변경하기
    public void setData(E na) {
        this.name = na;
    }

    public E getData() {
        return this.name;
    }

    // @Override
    // public String toString() {
    // return "Exam1 [name=" + name + "]";
    // }

}