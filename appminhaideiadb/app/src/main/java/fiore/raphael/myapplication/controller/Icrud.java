package fiore.raphael.myapplication.controller;

import java.util.List;

public interface Icrud<T> {

// MÉTODOS MÍNIMOS PARA PERSISTÊNCIA DADOS NO BANCO DE DADOS

// INCLUIR

    public boolean incluir(T obj);

//DELETAR

    public boolean deletar(int id);

//ALTERAR

    public boolean alterar(T obj);

//LISTAR

    public List<T> listar();

//CRUD - CREATE , RETRIEVE, UPDATE, DELETE

}
