package com.mad.mad_app;

public class dCartItem {
    private dItem dItem;
    private int quntity;


    public dCartItem() {
    }

    public dCartItem(dItem dItem, int quntity) {
        this.dItem = dItem;
        this.quntity = quntity;
    }

    public dItem getdItem() {
        return dItem;
    }

    public void setdItem(dItem dItem) {
        this.dItem = dItem;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }
}
