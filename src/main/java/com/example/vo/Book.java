package com.example.vo;

//Book.java
public class Book {

    // 1. 변수
    private long code = 0L; // 코드 :숫자형
    private String title = null; // 책 제목: 문자열형
    private int price = 0; // 가격 : 숫자형
    private String writer = null; // 저직지: 문자열형

    // 2. 생성자
    // 클래스를 만들면 자동으로 생성됨. 안 보임
    // 기능을 넣고 싶으면 만들어야함
    // set을 안해도 미리 값이 세팅되는 효과
    // 세팅을 안해도 되고, 2개만 해도 되고. 4개만 해도 됨
    // 파라미터에 따라 만들어 놓은 생성자를 선택한다.
    public Book() {

    }

    public Book(long code, String title) {
        this.code = code;
        this.title = title;
    }

    public Book(long code, String title, int price, String writer) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.writer = writer;
    }

    // getter , seter => 변수의 값을 변경하거나 가져가기 위해서
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // toString
    @Override
    public String toString() {
        return "Book [code=" + code + ", price=" + price + ", title=" + title + ", writer=" + writer + "]";
    }
}
