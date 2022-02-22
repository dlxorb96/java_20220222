package com.example.view;

import com.example.vo.Item;

public class Print1 {

    private Item[] items = null;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    // 메소드
    public void printAction1() {
        for (int i = 0; i < this.items.length; i++) {

            System.out.println("------------------------");
            System.out.println(this.items[i].getNo());
            System.out.println(this.items[i].getTitle());
            System.out.println(this.items[i].getQuantity());
            System.out.println(this.items[i].getPrice());
            System.out.println("------------------------");
        }
    }
}
