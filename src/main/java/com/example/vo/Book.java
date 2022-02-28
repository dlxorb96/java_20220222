package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
// Book.java
public class Book {
    // 1. 변수
    private long code = 0L; // 코드 :숫자형
    private String title = null; // 책 제목: 문자열형
    private int price = 0; // 가격 : 숫자형
    private String writer = null; // 저직지: 문자열형

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

    @Override
    public String toString() {
        return "Book [code=" + code + ", price=" + price + ", title=" + title +
                ",writer=" + writer + "]";
    }
}
