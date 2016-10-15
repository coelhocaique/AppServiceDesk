package android.projeto.com.br.appservicedesk.initializer;

import java.util.HashMap;

/**
 * Created by caiquecoelho on 10/7/16.
 */
public class StatusConverter {

    public static HashMap<Integer,String> statusName;


    static {
        statusName = new HashMap<>();
        statusName.put(1,"Aberto");
        statusName.put(2,"Fechado");
    }

}
