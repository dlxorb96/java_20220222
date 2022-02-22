package com.example.vo;

public class Item {

    // 물품번호 제목 가격 수량

    private int no = 0;
    private String title = null;
    private int price = 0;
    private int quantity = 0;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [no=" + no + ", price=" + price + ", quantity=" + quantity + ", title=" + title + "]";
    }

}
