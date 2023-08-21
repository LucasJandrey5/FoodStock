package br.dev.lucasjandrey.mobile.foodstock.model;

import org.json.JSONObject;

public class Food {
    private int id;
    private String name;
    private String description;
    private float price;
    private bool freeDelivery;


    public void FoodJson (JSONObject jp){

        //id
        Integer num = (int) jp.get("id");
        this.setId(num);
        //name
        String name = (String) jp.get("name");
        this.setName(name);

        String s = (String) jp.get("description");
        this.setDescription(s);
    }





    public Food(int id, String name, String description, float price, bool freeDelivery) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.freeDelivery = freeDelivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 3)
            this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public bool getFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(bool freeDelivery) {
        this.freeDelivery = freeDelivery;
    }
}
