package com.mad.mad_app;

public class CartItem {
    private Item item;
    private int quntity;


    public CartItem() {
    }

    public CartItem(Item item, int quntity) {
        this.item = item;
        this.quntity = quntity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }
}
