package android.projeto.com.br.appservicedesk.model;


/**
 * Created by asbonato on 9/18/16.
 */
public class Data {
   public static Chamado[] _lista;

    public static Chamado[] geraListaChamados(){
        if(_lista == null) {
            Chamado[] lista = new Chamado[12];
            lista[0] = new Chamado(1L,"Problema no compiuter",null,null,1,1);
            lista[1] = new Chamado(2L,"Problema no compiuter",null,null,1,1);
            lista[2] = new Chamado(3L,"Problema no compiuter",null,null,1,1);
            lista[3] = new Chamado(4L,"Problema no compiuter",null,null,1,1);
            lista[4] = new Chamado(5L,"Problema no compiuter",null,null,1,1);
            lista[5] = new Chamado(6L,"Problema no compiuter",null,null,1,1);
            lista[6] = new Chamado(7L,"Problema no compiuter",null,null,1,1);
            lista[7] = new Chamado(7L,"Problema no compiuter",null,null,1,1);
            lista[8] = new Chamado(8L,"Problema no compiuter",null,null,1,1);
            lista[9] = new Chamado(1L,"Problema no compiuter",null,null,1,1);
            lista[10] = new Chamado(1L,"Problema no compiuter",null,null,1,1);
            lista[11] = new Chamado(1L,"Problema no compiuter",null,null,1,1);
            _lista = lista;
        }
        return _lista;
    }

    public static Chamado[] buscaChamados(){
            Chamado[] lista = geraListaChamados();
            return lista;
    }
}

