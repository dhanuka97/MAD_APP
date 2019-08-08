package com.mad.mad_app;

import java.util.ArrayList;

public class ShoppingCart {

    public static ArrayList<dCartItem> cart = new ArrayList<>();

    public ShoppingCart() {
    }

    public static void addToCart(dCartItem item){
        cart.add(item);

    }
    public static ArrayList<dCartItem> getCart(){
        return cart;
    }

    public static void removeFromCart(dCartItem item) {
        cart.remove(item);
    }
}
