package com.example.componentesbasicos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static  int RESULT_ADD = 1;
    public static  int RESULT_EDIT = 2;

    EditText editTextConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextConteudo = findViewById(R.id.editTextConteudo);

    }
    public void Editar ( View view ) {
        Intent intent = new Intent( this, ContatoActivity.class);
        intent.putExtra( "nome", "Breno");
        intent.putExtra( "sobrenome", "Gonzaga");
        //iniciar uma tela sem retorno  //startActivity( intent );
        startActivityForResult(intent , RESULT_EDIT);
    }
    public void Adicionar ( View view ) {
        Intent intent = new Intent( this, ContatoActivity.class);
        intent.putExtra( "nome", "Breno");
        intent.putExtra( "sobrenome", "Gonzaga");
        //iniciar uma tela sem retorno  //startActivity( intent );
        startActivityForResult(intent , RESULT_ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ContatoActivity.RESULT_ADD) {
            // verificar resultado de retorno entre telas
            String result = "Resultado" + requestCode + "-" + resultCode;


            if (data.getExtras() != null) {
                String nome = (String) data.getExtras().get("nome");
                String telefone = (String) data.getExtras().get("telefone");
                String endereco = (String) data.getExtras().get("endereco");
               result += "-" + nome + "-" + telefone + "-" + endereco;

            }

            String conteudo = editTextConteudo.getText().toString();
            conteudo += result + '\n';
            editTextConteudo.setText(conteudo);
        } else if ( resultCode == ContatoActivity.RESULT_CANCEL){
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}
