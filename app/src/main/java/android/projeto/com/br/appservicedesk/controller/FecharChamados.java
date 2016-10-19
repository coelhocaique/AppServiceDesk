package android.projeto.com.br.appservicedesk.controller;

import android.content.Intent;
import android.os.Bundle;
import android.projeto.com.br.appservicedesk.R;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class FecharChamados extends AppCompatActivity {

    public static final String FILA = "android.projeto.com.br.appservicedesk.fila_index";
    private Spinner escolherFila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar_chamados);
        setContentView(R.layout.activity_lista_por_fila);
        escolherFila = (Spinner) findViewById(R.id.escolherFila);
        //escolherFila = InitializeSpinner.initializeAndSetAdapterSppinerForFila(escolherFila,this);
    }

    public void listarChamados(View view){
        Intent intent = new Intent(this,FecharChamadosLista.class);
        intent.putExtra(FILA,String.valueOf(escolherFila.getSelectedItemPosition() + 1));
        startActivity(intent);
    }
}
