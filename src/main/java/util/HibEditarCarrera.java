package util;

import entidades.Carrera;
import entidades.Facultad;
import jakarta.persistence.EntityManager;
import util.JPA;


import javax.swing.*;

public class HibEditarCarrera {

    public static void editarCarrera() {
        EntityManager em = JPA.getEntityManager();

        try {
            // Solicitar el ID de la carrera que se va a editar
            String idCarreraInput = JOptionPane.showInputDialog("Digite el ID de la carrera que desea editar:");
            Long idCarrera;
            try {
                idCarrera = Long.valueOf(idCarreraInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID de la carrera debe ser un número válido.");
                return;
            }

            // Buscar la carrera por su ID
            Carrera carrera = em.find(Carrera.class, idCarrera);
            if (carrera == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna carrera con el ID especificado.");
                return;
            }

            // Mostrar la información actual de la carrera
            JOptionPane.showMessageDialog(null, "Carrera actual: " + carrera.getNombre() + " - Tipo: " + carrera.getTipo());

            // Solicitar nuevos datos para la carrera
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la carrera (deje vacío para no cambiar):");
            String nuevoTipoInput = JOptionPane.showInputDialog("Ingrese el nuevo tipo de carrera (deje vacío para no cambiar):");

            // Validar si el nombre no está vacío y cambiarlo
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                carrera.setNombre(nuevoNombre);
            }

            // Validar si el tipo es un número y cambiarlo
            if (nuevoTipoInput != null && !nuevoTipoInput.trim().isEmpty()) {
                try {
                    int nuevoTipo = Integer.parseInt(nuevoTipoInput);
                    carrera.setTipo(nuevoTipo);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El tipo de carrera debe ser un número válido.");
                    return;
                }
            }

            // Iniciar la transacción
            em.getTransaction().begin();

            // Actualizar la carrera en la base de datos
            em.merge(carrera);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Carrera actualizada con éxito. ID: " + carrera.getId());

        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al editar la carrera. Inténtelo de nuevo.");
        } finally {
            // Cerrar el EntityManager
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
