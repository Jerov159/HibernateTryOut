package util;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;
import java.util.List;

public class HibListarCarrera {

    public static void listarTodasLasCarreras() {
        EntityManager em = JPA.getEntityManager();

        try {
            // Consulta para listar todas las carreras
            List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();

            if (carreras.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay carreras disponibles.");
            } else {
                // Mostrar las carreras encontradas
                carreras.forEach(carrera -> System.out.println(carrera));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al listar las carreras.");
            e.printStackTrace();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}

