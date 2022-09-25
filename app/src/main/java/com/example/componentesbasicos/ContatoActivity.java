package com.example.componentesbasicos;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContatoActivity extends AppCompatActivity {

    public static  int RESULT_ADD = 1;
    public static  int RESULT_CANCEL = 2;

    EditText edtNome;
    EditText edtTelefone;
    EditText edtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        //passando informação da primeira tela pra segunda
        //String nome = (String) getIntent().getExtras().get("NOME");
        //String sobrenome = (String) getIntent().getExtras().get("SOBRENOME");

        edtNome = findViewById(R.id.editTextNome);
        edtTelefone = findViewById(R.id.editTextTelefone);
        edtEndereco = findViewById(R.id.editTextEndereco);

        String nome = edtNome.getText().toString();
        String telefone = edtTelefone.getText().toString();
        String endereco = edtEndereco.getText().toString();
    }
    public void adicionar ( View view ) {
        Intent intent = new Intent();

        String nome = edtNome.getText().toString();
        String telefone = edtTelefone.getText().toString();
        String endereco = edtEndereco.getText().toString();

        intent.putExtra( "nome", nome);
        intent.putExtra( "telefone", telefone);
        intent.putExtra( "endereco", endereco);

        setResult(RESULT_ADD, intent);
        finish();
    }
    public void cancelar ( View view ) {
        setResult(RESULT_CANCEL);
        finish();
    }
}