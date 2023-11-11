package br.dev.lucasjandrey.mobile.foodstock.model;

import androidx.fragment.app.strictmode.FragmentStrictMode;

import org.json.JSONException;
import org.json.JSONObject;

public class Food {
    private int id;
    private String name;
    private String description;
    private float price;
    private boolean freeDelivery;
    private boolean combo;


    public void FoodJson (JSONObject jp) throws JSONException {

        //id
        Integer num = (int) jp.get("id");
        this.setId(num);
        //name
        String name = (String) jp.get("name");
        this.setName(name);

        String s = (String) jp.get("description");
        this.setDescription(s);

        Float p = (float) jp.get("price");
        this.setPrice(num);


    }

    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("idanimal", this.id);
            json.put("nome", this.name);
            json.put("descricao", this.description);
            json.put("preco", this.price);
            json.put("freteGratis", this.freeDelivery);
            json.put("combo", this.combo);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Food() {
        this.setId(0);
        this.setName("");
        this.setDescription("");
        this.setPrice(0);
        this.setFreeDelivery(false);
        this.setCombo(false);
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

    public boolean getFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    public boolean isCombo() {
        return combo;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }
}
