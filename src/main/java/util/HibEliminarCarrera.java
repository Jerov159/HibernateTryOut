package util;

import entidades.Carrera;
import entidades.Facultad;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;

public class HibEliminarCarrera {

    public static void eliminarCarrera() {
        EntityManager em = JPA.getEntityManager();
        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Digite el código de carrera a eliminar:"));
            Carrera ca = em.find(Carrera.class, id);

            if (ca == null) {
                JOptionPane.showMessageDialog(null, "Carrera no encontrada.");
                return;
            }

            em.getTransaction().begin();
            em.remove(ca);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Carrera eliminada con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar la carrera.");
        } finally {
            em.close();
        }
    }
}
