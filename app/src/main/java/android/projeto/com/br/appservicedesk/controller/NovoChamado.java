package android.projeto.com.br.appservicedesk.controller;

import android.projeto.com.br.appservicedesk.R;
import android.projeto.com.br.appservicedesk.initializer.InitializeSpinner;
import android.projeto.com.br.appservicedesk.model.Chamado;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class NovoChamado extends AppCompatActivity {

    private Spinner tiposDeFila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_chamado);
        tiposDeFila = (Spinner) findViewById(R.id.tiposDeFila);
        tiposDeFila = InitializeSpinner.initializeAndSetAdapterSppinerForFila(tiposDeFila,this);
    }


    public void registrarChamado(View view){
        EditText text = (EditText) findViewById(R.id.descricao);
        String descricao = text.getText().toString();
        int fila = tiposDeFila.getSelectedItemPosition();

        if(descricao != null && !descricao.isEmpty()) {
            Chamado chamado = new Chamado(descricao, 1, fila);//1-estado aberto


        }else{
            setContentView(R.layout.error_message);
        }
    }

}
