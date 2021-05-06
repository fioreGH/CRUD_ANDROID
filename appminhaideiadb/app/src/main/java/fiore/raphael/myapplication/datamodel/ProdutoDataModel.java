package fiore.raphael.myapplication.datamodel;

public class ProdutoDataModel {

//MODELO OBJETO RELACIONAL

//1- ATRIBUTO NOME DA TABELA

    public static final String TABELA = "produto";

//2- ATRIBUTOS 1 PARA 1 COM NOMES DOS CAMPOS

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FORNECEDOR = "fornecedor";

//3- QUERY PARA CRIAR A TABELA NO BANCO DE DADOS

    public static String queryCriarTabela = "";

//4 - MÉTODO PARA GERAR O SCRIPT PARA CRIAR A TABELA

    public static String criarTabela(){

        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela +=ID+" integer primary key autoincrement, ";
        queryCriarTabela +=NOME+" text, ";
        queryCriarTabela +=FORNECEDOR+" text ";
        queryCriarTabela +=")";

        return queryCriarTabela;
    }





}
