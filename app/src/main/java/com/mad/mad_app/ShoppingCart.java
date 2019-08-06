package com.mad.mad_app;

import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingCart {

    public static ArrayList<CartItem> cart = new ArrayList<>();

    public ShoppingCart() {
    }

    public static void addToCart(CartItem item){
        cart.add(item);

    }
    public static ArrayList<CartItem> getCart(){
        return cart;
    }

    public static void removeFromCart(CartItem item) {
        cart.remove(item);
    }
}
