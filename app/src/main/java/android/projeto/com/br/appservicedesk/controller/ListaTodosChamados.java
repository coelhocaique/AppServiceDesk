package android.projeto.com.br.appservicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.projeto.com.br.appservicedesk.R;
import android.projeto.com.br.appservicedesk.dao.ChamadoDao;
import android.projeto.com.br.appservicedesk.enums.TiposDeBusca;
import android.projeto.com.br.appservicedesk.initializer.StatusConverter;
import android.projeto.com.br.appservicedesk.model.Chamado;
import android.projeto.com.br.appservicedesk.model.ChamadoAdapter;
import android.projeto.com.br.appservicedesk.model.Data;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;


public class ListaTodosChamados extends AppCompatActivity {

    public static final String NUMERO = "android.projeto.com.br.appservicedesk.numero_det";
    public static final String DESCRICAO = "android.projeto.com.br.appservicedesk.descricao_det";
    public static final String STATUS = "android.projeto.com.br.appservicedesk.status_det";
    Activity atividade;
    Chamado[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_todos_chamados);
        atividade = this;
        Intent intent = getIntent();
        lista = Data.buscaChamados();
        BaseAdapter adapter = new ChamadoAdapter(this, lista);
        ListView listView = (ListView) findViewById(R.id.lista_chamados);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheChamadosActivity.class);
                intent.putExtra(NUMERO, String.valueOf(lista[position].getNumero()));
                intent.putExtra(DESCRICAO, lista[position].getDescricao());
                intent.putExtra(STATUS, StatusConverter.statusName.get(lista[position].getStatus()));

                startActivity(intent);

            }

        });

    }
}
