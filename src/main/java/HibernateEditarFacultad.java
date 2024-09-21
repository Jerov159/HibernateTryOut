import entidades.Facultad;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;

public class HibernateEditarFacultad {
    public static void main(String[] args) {

        EntityManager em= JPA.getEntityManager();

        try {
            // Solicitar un Id
            Long id=Long.valueOf((JOptionPane.showInputDialog("Ingrese un código de facultad a modificar: ")));
            // Se busca en la base de datos
            Facultad fa =em.find(Facultad.class,id);

            // Se solicitan los nuevos datos
            String nombre=JOptionPane.showInputDialog("Ingrese nuevo nombre de facultad: ",fa.getNombre());
            String abreviatura=JOptionPane.showInputDialog("Ingrese abreviatura de facultad: ",fa.getAbreviatura());

            // Se inicia transacción
            em .getTransaction().begin();
            //Pasamos los nuevos valores
            fa.setNombre(nombre);
            fa.setAbreviatura(abreviatura);
            // TODO
            em.merge(fa);

            // Hasta el momento los datos han sido cambiados en las entidades / objetos pero no se han sincronizado con la BD
            em.getTransaction().commit(); //Se sincronizan los datos a la BD
            // Se publica el registro modificado
            System.out.println(fa);

        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("Se ha generado el error: " + e.getMessage());
        }finally {
            em.close();
        }
    }
}
