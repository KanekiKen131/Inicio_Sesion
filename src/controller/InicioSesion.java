/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class InicioSesion {
    private Utilidades u = new Utilidades();
    private final String file_name = "Usuario.dat";

    public boolean guardar_usuario(String nombre, String clave) {
        String data = generar_numeracion() + "\t" + nombre + "\t" + clave + "\n";
        try {
            u.save(data, file_name);
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
            return false;
        }
    }

    public String[][] listar() {
        try {
            String[][] data = u.listAll(file_name);
            return (data != null) ? data : new String[0][0];
        } catch (Exception e) {
            System.err.println("Error al listar archivos desde " + file_name + ": " + e.getMessage());
            return new String[0][0];
        }
    }

    public String generar_numeracion() {
        String[][] listado = listar();
        int num = (listado != null) ? listado.length + 1 : 1;
        return String.format("%06d", num);
    }
    
    public int inicioSesion(String usuarioIngresado, String claveIngresada) {
        String[][] usuarios = listar();
        if (usuarios.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return 0;
        }
        for (String[] fila : usuarios) {
            if (fila.length >= 3) {
                String nr_usuario = fila[0];
                String usuario = fila[1];
                String clave = fila[2];
                if (usuario.equals(usuarioIngresado)) {
                    if (clave.equals(claveIngresada)) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido, " + usuario + ".");
                        return 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                        return 2;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        return 3;
    }
}

