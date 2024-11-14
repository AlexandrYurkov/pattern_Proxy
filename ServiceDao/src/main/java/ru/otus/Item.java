package ru.otus;

public class Item {
    private final int id;
    private final String title;
    private int price;

    public Item(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int newPrice){
       price = newPrice;
    }
}
