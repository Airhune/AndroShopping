package com.androshopping.androshopping;

public class ChartItem {
    public String name;
    public int price;
    public int imgSrc;
    public int quantity;

    public ChartItem(String n, int p, int src) {
        this.name = n;
        this.price = p;
        this.quantity = 1;
        this.imgSrc = src;
    }
}
