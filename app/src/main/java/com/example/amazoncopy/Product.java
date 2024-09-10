package com.example.amazoncopy;

public class Product {
    private String name;
    private String price;
    private String imageResId;

    public Product(String name, String price, String imageResId) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
    }
        public String getName(){
            return name;
        }
        public String getPrice(){
            return price;
        }
        public String getImageResId(){
            return imageResId;
        }

    }
