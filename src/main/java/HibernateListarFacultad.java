import entidades.Facultad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPA;

import java.util.Scanner;

public class HibernateListarFacultad {
    public static void main(String[] args) {

        // Se usa Scanner para solicitar un valor por teclado al usuario
        Scanner s =new Scanner(System.in);

        // Importamos el em de Entitymanager
        EntityManager em= JPA.getEntityManager();

        // Se crea la consulta, al final se le aclara que se va a tener un objeto de tipo facultad, antes no se declaro
        // Consulta preparada pero con JPA; ?=1 significa que es el parámetro 1 e inicia en 1
        //TODO
        Query consulta=em.createQuery("select f from Facultad f where f.id=?1", Facultad.class);

        System.out.print("Ingrese un código de facultad: ");
        String id = s.next();
        // Observar que el Id es un Long, pero la variable id es de tipo string
        consulta.setParameter(1,id);
        // El query retorna un objeto, asi que se debe convertir
        //TODO
        Facultad fa= (Facultad) consulta.getSingleResult();

        // Se imprime el resultado
        System.out.println(fa);
        // Se cierra el entityManager
        em.close();
        // AL USAR getSingleResult ESTE SOLO RETORNA UN VALOR, intente cambiar en la consulta el = por >


    }
}
