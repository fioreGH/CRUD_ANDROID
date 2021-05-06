package fiore.raphael.myapplication.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fiore.raphael.myapplication.api.AppUtil;
import fiore.raphael.myapplication.datamodel.ProdutoDataModel;
import fiore.raphael.myapplication.datasource.AppDataBase;
import fiore.raphael.myapplication.model.Produto;

public class ProdutoController extends AppDataBase implements Icrud<Produto>{

    ContentValues dadosDoObjeto;

    public ProdutoController(Context context) {
        super(context);

        Log.d(AppUtil.TAG,"ProdutoController: Conectado");
    }


    @Override
    public boolean incluir(Produto obj) {

        /*ENVIAR OS DADOS (DADODOOBJETO) PARA A CLASSE APPDATABASE
        UTILIZANDO UM MÉDOTO CAPAZ DE INSERIR O OBJ NO BANCO DE DADOS
        DE QUALQUER TABELA (NESTE CASO PRODUTO)*/

        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put("nomeProduto",obj.getNome());
        dadosDoObjeto.put("fornecedor",obj.getFornecedor());


        return insert(ProdutoDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean deletar(int id) {


        return true;
    }

    @Override
    public boolean alterar(Produto obj) {
        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put("id",obj.getId());
        dadosDoObjeto.put("nomeProduto",obj.getNome());
        dadosDoObjeto.put("fornecedor",obj.getFornecedor());

        return true;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
