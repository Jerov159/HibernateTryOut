package util;

import entidades.Carrera;
import entidades.Facultad;
import jakarta.persistence.EntityManager;
import util.JPA;

import javax.swing.*;

public class HibCrearCarrera {

    public static void crearCarrera() {
        EntityManager em = JPA.getEntityManager();
        try {
            // Solicitar el nombre de la carrera
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carrera:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre de la carrera no puede estar vacío.");
                return;
            }

            // Solicitar el tipo de carrera y validar si es un número entero
            String tipoInput = JOptionPane.showInputDialog("Digite el tipo de carrera (como un número):");
            int tipo;
            try {
                tipo = Integer.parseInt(tipoInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El tipo de carrera debe ser un número.");
                return;
            }

            // Solicitar el ID de la facultad y validar si es un número long
            String idFacultadInput = JOptionPane.showInputDialog("Digite el ID de la facultad:");
            Long idFacultad;
            try {
                idFacultad = Long.valueOf(idFacultadInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID de la facultad debe ser un número válido.");
                return;
            }

            // Buscar la facultad por su ID
            Facultad facultad = em.find(Facultad.class, idFacultad);
            if (facultad == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna facultad con el ID especificado.");
                return;
            }

            // Iniciar la transacción
            em.getTransaction().begin();

            // Crear una nueva carrera y asignar los valores
            Carrera carrera = new Carrera();
            carrera.setNombre(nombre);
            carrera.setTipo(tipo);
            carrera.setFacultad(facultad); // Asignar la facultad encontrada

            // Persistir la nueva carrera
            em.persist(carrera);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar el ID de la nueva carrera creada
            JOptionPane.showMessageDialog(null, "Carrera creada con éxito. El nuevo código de carrera es: " + carrera.getId());
        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear la carrera. Inténtelo de nuevo.");
        } finally {
            // Cerrar el EntityManager
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
