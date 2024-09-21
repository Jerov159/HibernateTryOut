package view;

import javax.swing.*;
import util.*;


public class Main {
    public static void main(String[] args) {
        while (true) {
            // Menú principal para elegir una operación
            String[] opciones = {
                    "Crear Carrera",
                    "Editar Carrera",
                    "Listar Todas las Carreras",
                    "Listar Carreras por ID mayor",
                    "Buscar una Carrera por ID",
                    "Salir"
            };

            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Sistema de Gestión de Carreras",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    // Crear Carrera
                    HibCrearCarrera.crearCarrera();
                    break;
                case 1:
                    // Editar Carrera
                    HibEditarCarrera.editarCarrera();
                    break;
                case 2:
                    // Listar Todas las Carreras
                    HibListarCarrera.listarTodasLasCarreras();
                    break;
                case 3:
                    // Listar Carreras con ID mayor a un valor
                    HibListarMuchasCarreras.listarCarrerasConIdMayor();
                    break;
                case 4:
                    // Buscar una Carrera por ID
                    HibListarUnaCarrera.buscarCarreraPorId();
                    break;
                case 5:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}

