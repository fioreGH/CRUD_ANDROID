package fiore.raphael.myapplication.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import fiore.raphael.myapplication.api.AppUtil;
import fiore.raphael.myapplication.datamodel.ClienteDataModel;
import fiore.raphael.myapplication.datamodel.ProdutoDataModel;
import fiore.raphael.myapplication.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando o banco de Dados");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente... criada " + ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Produto... criada " + ProdutoDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

//METODO PARA INCLUIR NO BANCO DE DADOS

    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

//REGRA DE NEGOCIO

        try {

            retorno = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "inserir: " + e.getMessage());
        }

        return retorno;
    }

//MÉTODO PARA EXCLUIR NO BANCO DE DADOS

    public boolean deleteById(String tabela, int id) {

        db = getWritableDatabase();

        boolean retorno = false;

//REGRA DE NEGOCIO

        try {

            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "deletar: " + e.getMessage());
        }

        return retorno;
    }

//MÉTODO PARA ALTERAR NO BANCO DE DADOS

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

//REGRA DE NEGOCIO

        try {

            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "atualizar: " + e.getMessage());
        }

        return retorno;
    }

//MÉTODO PARA LISTAR OS CLIENTES DO BANCO DE DADOS

    public List<Cliente> getAllClientes(String tabela) {

        db = getWritableDatabase();

        Cliente obj;

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);

            } while (cursor.moveToNext());

        }

        return clientes;

    }

}
