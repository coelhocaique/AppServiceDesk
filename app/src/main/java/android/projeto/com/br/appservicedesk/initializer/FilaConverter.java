package android.projeto.com.br.appservicedesk.initializer;

import java.util.HashMap;

/**
 * Created by caiquecoelho on 10/7/16.
 */
public class FilaConverter {

    public static HashMap<Integer, String> filaName;

    static {
        filaName = new HashMap<>();
        filaName.put(1,"Redes");
        filaName.put(2,"Software");
    }
}
