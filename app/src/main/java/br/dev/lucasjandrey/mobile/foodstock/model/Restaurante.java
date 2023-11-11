package br.dev.lucasjandrey.mobile.foodstock.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Restaurante {
    private int id;
    private String nome;
    private String descricao;
    private String endereco;
    private String horario;

    public void FoodJson (JSONObject jp) throws JSONException {
        String s;
        //id
        Integer num = (int) jp.get("id");
        this.setId(num);
        //name
        s = (String) jp.get("nome");
        this.setNome(s);

        s = (String) jp.get("descricao");
        this.setDescricao(s);

        s = (String) jp.get("endereco");
        this.setDescricao(s);

        s = (String) jp.get("horario");
        this.setHorario(s);
    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("idrestaurante", this.id);
            json.put("nome", this.nome);
            json.put("descricao", this.descricao);
            json.put("endereco", this.endereco);
            json.put("horario", this.horario);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Restaurante() {
        this.setId(0);
        this.setNome("");
        this.setDescricao("");
        this.setEndereco("");
        this.setHorario("");

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
