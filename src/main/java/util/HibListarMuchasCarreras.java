package util;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPA;

import javax.swing.*;
import java.util.List;

public class HibListarMuchasCarreras {

    public static void listarCarrerasConIdMayor() {
        EntityManager em = JPA.getEntityManager();

        try {
            // Solicitar al usuario un ID mínimo
            String idMinStr = JOptionPane.showInputDialog("Ingrese el ID mínimo de la carrera:");
            Long idMin;

            try {
                idMin = Long.parseLong(idMinStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
                return;
            }

            // Crear la consulta con el parámetro ingresado
            Query consulta = em.createQuery("SELECT c FROM Carrera c WHERE c.id > :idMin", Carrera.class);
            consulta.setParameter("idMin", idMin);

            // Obtener los resultados de la consulta
            List<Carrera> carreras = consulta.getResultList();

            if (carreras.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron carreras con un ID mayor a " + idMin);
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


