package visao;

import modelo.Publicacao;
import modelo.PublicacaoDAO;

public class Principal {
    
    public static void main(String args[]){
        
        PublicacaoDAO pDao = new PublicacaoDAO();
        pDao.createIndex();

//        Publicacao pubA = new Publicacao("Publicacao teste A - Mongo", "Joao", "Conteudo teste");
//        Publicacao pubB = new Publicacao("Publicacao B", "Maria", "Conteudo da publicacao B - Mongo");
//        Publicacao pubC = new Publicacao("Conteudo Teste C", "Joao", "Publicacao Teste - Mongo");
//
//        pDao.add(pubA);
//        pDao.add(pubB);
//        pDao.add(pubC);

        Publicacao p = pDao.readFirst("Publicacao");
        
        System.out.println(p);

                
    }
    
}
