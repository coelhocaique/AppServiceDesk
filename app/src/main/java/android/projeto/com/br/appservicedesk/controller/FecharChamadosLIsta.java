package android.projeto.com.br.appservicedesk.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.projeto.com.br.appservicedesk.R;
import android.projeto.com.br.appservicedesk.initializer.StatusConverter;
import android.projeto.com.br.appservicedesk.model.Chamado;
import android.projeto.com.br.appservicedesk.model.ChamadoAdapter;
import android.projeto.com.br.appservicedesk.model.Data;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class FecharChamadosLista extends AppCompatActivity {

    public static final String NUMERO = "android.projeto.com.br.appservicedesk.numero_det";
    public static final String DESCRICAO = "android.projeto.com.br.appservicedesk.descricao_det";
    public static final String STATUS = "android.projeto.com.br.appservicedesk.status_det";
    Activity atividade;
    Chamado[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechar_chamados_lista);
        atividade = this;
        Intent intent = getIntent();
        lista = Data.buscaChamados();
        BaseAdapter adapter = new ChamadoAdapter(this, lista);
        ListView listView = (ListView) findViewById(R.id.fecha_chamados);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                new AlertDialog.Builder(atividade)
                        .setTitle(R.string.fechar_chamado)
                        .setMessage(R.string.fechar_chamado_confirmation)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        });

    }
}
