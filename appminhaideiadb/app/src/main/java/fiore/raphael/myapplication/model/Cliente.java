package fiore.raphael.myapplication.model;

import android.util.Log;

import fiore.raphael.myapplication.api.AppUtil;
import fiore.raphael.myapplication.controller.Icrud;

public class Cliente {

    private int id; //chave primaria no BD
    private String nome;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
