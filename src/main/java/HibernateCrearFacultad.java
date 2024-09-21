import entidades.Facultad;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;

public class HibernateCrearFacultad {
    public static void main(String[] args) {
        EntityManager em = JPA.getEntityManager();

        try {
            // Se usa JOptionPane para solicitar datos al usuario
            String nombre= JOptionPane.showInputDialog("Ingrese nombre de facultad");
            String abreviatura=JOptionPane.showInputDialog("Digite la sigla de la facultad");

            // Iniciar la transacción
            //TODO
            em.getTransaction().begin();


            // Se crea objeto con nuevos valores
            Facultad fa = new Facultad();
            fa.setNombre(nombre);
            fa.setAbreviatura(abreviatura);

            // Comando que en realidad guarda los datos en el OBJETO y en la BD, pero temporalmente hasta aceptar la transacción
            //TODO
            em.persist(fa);


            // Lanza la petición a la base de datos y SE GUARDA EN LA MISMA
            //TODO
            em.getTransaction().commit();

            // Como se tiene una copia de la tabla en memoria, se puede consultar en el objeto el nuevo Id generado, sin tener que hacer una consulta a la BD
            System.out.println("El nuevo código de facultad es: "+ fa.getId());
            //TODO


            //Se puede hacer una consulta por el Id, por ello se usa .find
            fa=em.find(Facultad.class,fa.getId());
            System.out.println(fa);

        } catch (Exception e) {
            //En caso de error se retorna la transacción o se cancela
            em.getTransaction().rollback();
            //Imprimir la traza
            e.printStackTrace();

        } finally {
            //Siempre cerrar la conexion de entitymanager
            em.close();

        }
    }
}
