package android.projeto.com.br.appservicedesk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by asbonato on 9/19/16.
 */
public class SectionIndexBuilder {
    //cria um array de cabecalhos unicos de secao; os dados devem estar ordenados pelo numero do chamado
    public static Object[] BuildSectionHeaders(Chamado[] chamados)
    {
        List<Long> results = new ArrayList<>();

        if(chamados != null && chamados.length > 0) {
            for (int i = 0; i < chamados.length; i++) {
                Long number = chamados[i].getNumero();

                if (!results.contains(number))
                    results.add(number);
            }
        }

        Collections.sort(results);
        return results.toArray(new Object[0]);
    }

    //cria um mapa para responder: posicao --> secao de dados ordenados pelo numero do chamado
    public static Hashtable<Integer, Integer> BuildSectionForPositionMap(Chamado[] chamados)
    {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        List<Long> used = new ArrayList<>();
        int section = -1;

        if(chamados != null && chamados.length > 0) {
            for (int i = 0; i < chamados.length; i++) {
                Long number = chamados[i].getNumero();

                if (!used.contains(number)) {
                    section++;
                    used.add(number);
                }

                results.put(i, section);
            }
        }
        return results;
    }

    //cria um mapa para responder: secao --> posicao de dados ordenados pelo numero do chamado
    public static Hashtable<Integer, Integer> BuildPositionForSectionMap(Chamado[] chamados)
    {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        List<Long> used    = new ArrayList<>();
        int section = -1;

        if(chamados != null && chamados.length > 0) {
            for (int i = 0; i < chamados.length; i++) {
                Long numero = chamados[i].getNumero();

                if (!used.contains(numero)) {
                    section++;
                    used.add(numero);
                    results.put(section, i);
                }
            }

        }
        return results;
    }
}
