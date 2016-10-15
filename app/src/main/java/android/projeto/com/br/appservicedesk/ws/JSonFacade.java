package android.projeto.com.br.appservicedesk.ws;

import android.projeto.com.br.appservicedesk.model.Chamado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by caiquecoelho on 10/14/16.
 */
public class JSonFacade {

    /*public static StringBuilder montaJSon(Http request)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        return sb;
    }*/

    public static String listToJSon(ArrayList<Chamado> lista) {
        JSONArray vetor = new JSONArray();
        for (Chamado chamado : lista) {
            JSONObject object = new JSONObject();
            try {
                object.put("numero",chamado.getNumero());
                object.put("descricao", chamado.getDescricao());
                object.put("dataFechamento",chamado.getDataDeFechamento().toString());
                object.put("dataAbertura", chamado.getDataAbertura().toString());
                object.put("fila",chamado.getFila());
                object.put("status",chamado.getStatus());
                vetor.put(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return vetor.toString();
    }

    public static Chamado jSonToChamado(String json) throws Exception{
        try{
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            JSONObject registro = new JSONObject(json);
            long numero = registro.getLong("numero");
            String descricao = registro.getString("descricao");
            String dataAbertura = registro.getString("dataAbertura");
            String dataFechamento = registro.getString("dataFechamento");
            int fila = registro.getInt("fila");
            int status = registro.getInt("status");

            Date abertura = null,fechamento = null;
            if(dataAbertura != null && !dataAbertura.isEmpty()){
                abertura = dateformat.parse(dataAbertura);
            }
            if(dataFechamento != null && !dataFechamento.isEmpty()){
                fechamento = dateformat.parse(dataFechamento);
            }
            return new Chamado(numero,descricao,fechamento,abertura,fila,status);
        } catch(JSONException jsone){
            jsone.printStackTrace();
            throw new IOException(jsone);
        } catch (ParseException e) {
            throw e;
        }
    }

    public static String chamadoToJSon(Chamado chamado) throws IOException {
        JSONObject object = new JSONObject();
        try {
            object.put("numero",chamado.getNumero());
            object.put("descricao", chamado.getDescricao());
            object.put("dataFechamento",chamado.getDataDeFechamento().toString());
            object.put("dataAbertura", chamado.getDataAbertura().toString());
            object.put("fila",chamado.getFila());
            object.put("status",chamado.getStatus());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    public static String errorToJSon(Exception e) {
        JSONObject object = new JSONObject();
        try {
            object.put("error", e.toString());
        } catch (JSONException e1) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
