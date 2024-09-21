import entidades.Facultad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPA;

import java.util.List;
import java.util.Scanner;

public class HibernateListarWhereMuchosFacultad {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);

        EntityManager em= JPA.getEntityManager();

        Query consulta =em.createQuery("SELECT f from Facultad f where f.id>?1", Facultad.class);

        System.out.print("Ingrese un código de facultad: ");
        String id = s.next();

        consulta.setParameter(1,id);
        //TODO
        List<Facultad> fa = consulta.getResultList();
        System.out.println(fa);


        em.close();

    }
}
