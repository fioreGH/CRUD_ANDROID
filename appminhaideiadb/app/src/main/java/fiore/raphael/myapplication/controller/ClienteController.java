package fiore.raphael.myapplication.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fiore.raphael.myapplication.api.AppUtil;
import fiore.raphael.myapplication.datamodel.ClienteDataModel;
import fiore.raphael.myapplication.datasource.AppDataBase;
import fiore.raphael.myapplication.model.Cliente;

public class ClienteController extends AppDataBase implements Icrud<Cliente> {

    ContentValues dadoDoObjeto; //declara o objeto

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG,"ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        /*ENVIAR OS DADOS (DADODOOBJETO) PARA A CLASSE APPDATABASE
        UTILIZANDO UM MÉDOTO CAPAZ DE INSERIR O OBJ NO BANCO DE DADOS
        DE QUALQUER TABELA (NESTE CASO CLIENTE)*/

        dadoDoObjeto = new ContentValues(); //instancia o objeto
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome()); //key, value
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail()); //chave, valor

        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteById(ClienteDataModel.TABELA,id);

    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues(); //instancia o objeto
        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId()); //neste caso passa o ID para poder alterar
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome()); //caso queira mudar o nome
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail()); //caso queira mudar o email

        return update(ClienteDataModel.TABELA,dadoDoObjeto);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);
    }
}
