package com.example.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Item {

    // 물품번호 제목 가격 수량

    private Long no = 0L;
    private String title = null;
    private int price = 0;
    private int quantity = 0;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
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

    public Item(Long no, String title, int price, int quantity) {
        this.no = no;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {
    }

}
