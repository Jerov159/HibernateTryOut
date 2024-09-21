package util;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;

public class HibListarUnaCarrera {

    public static void buscarCarreraPorId() {
        EntityManager em = JPA.getEntityManager();

        try {
            // Solicitar al usuario que ingrese el ID de la carrera
            String idStr = JOptionPane.showInputDialog("Ingrese el ID de la carrera que desea buscar:");
            Long idCarrera;

            try {
                idCarrera = Long.parseLong(idStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
                return;
            }

            // Buscar la carrera por su ID
            Carrera carrera = em.find(Carrera.class, idCarrera);

            if (carrera == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna carrera con el ID especificado.");
            } else {
                // Mostrar los detalles de la carrera
                JOptionPane.showMessageDialog(null, "Carrera encontrada: " + carrera);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar la carrera.");
            e.printStackTrace();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}


