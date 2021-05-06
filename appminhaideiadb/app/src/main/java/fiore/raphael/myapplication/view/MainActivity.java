package fiore.raphael.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import fiore.raphael.myapplication.R;
import fiore.raphael.myapplication.api.AppUtil;
import fiore.raphael.myapplication.controller.ClienteController;
import fiore.raphael.myapplication.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: AppMinhaIdeia DataBase");

        clienteController = new ClienteController(getApplicationContext());

       /* //INCLUIR CLIENTE*****************************************************************
        for (int i = 0; i < 49; i++) {

            obj = new Cliente();

            obj.setNome("Raphael Fiore "+ i);
            obj.setEmail(i+"_fiore@gmail.com");

            clienteController.incluir(obj);
        }

        if (clienteController.incluir(obj)) {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " incluido com sucesso...", Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente:" + obj.getNome() + " incluido com sucesso");

        } else {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " erro ao incluir...", Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente:" + obj.getNome() + " erro ao incluir o cliente");

        }*/

        /*//EXCLUIR CLIENTE*******************************************************************

        obj.setId(2); //tem que passar o id
        obj.setNome("Marcelino Freitas");
        obj.setEmail("freitas@gmail.com");

        if (clienteController.deletar(obj.getId())) {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " excluido com sucesso...", Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente:" + obj.getNome() + " excluido com sucesso");

        } else {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " erro ao excluir...", Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente:" + obj.getNome() + " erro ao excluir o cliente");

        }

        //ALTERAR CLIENTE*****************************************************************

        obj.setId(3);  //passa o id
        obj.setNome("Pedro Alcantara"); //prepara o cliente antes (ja põe a alteração aqui)
        obj.setEmail("alcantara@gmail.com"); //prepara o cliente antes (ja põe a alteração aqui)

        if (clienteController.alterar(obj)) {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " alterado com sucesso...", Toast.LENGTH_SHORT).show();
            Log.i(AppUtil.TAG, "Cliente:" + obj.getNome() + " alterado com sucesso");

        } else {

            Toast.makeText(MainActivity.this, "Cliente: " + obj.getNome() + " erro ao alterar...", Toast.LENGTH_SHORT).show();
            Log.e(AppUtil.TAG, "Cliente:" + obj.getNome() + " erro ao alterar o cliente");

        }*/

        //LISTAR CLIENTE*****************************************************************
        for (Cliente obj: clienteController.listar()) {
            Log.i("retorno","Cliente: " + obj.getId() + " " + obj.getNome() + " " + obj.getEmail());
        }
    }
}