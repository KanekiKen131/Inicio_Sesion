/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author alexa
 */
public class InicioSesion {

     private Utilidades u = new Utilidades();
    private String file_name = "Usuario.dat";
     public boolean guardar_usuario(String nombre, String clave) {
    String data = nombre + "\t" + clave + "\n";
    try {
        u.save(data, file_name);
        return true;
    } catch (Exception e) {
        System.err.println("Error al guardar usuario: " + e.getMessage());
        return false;
    }
}
     public boolean existeUsuario(String usuario) {
       try {
        List<String> lines = u.readLines(file_name);
        for (String line : lines) {
            String[] partes = line.split("\t");
            if (partes.length >= 1 && partes[0].equalsIgnoreCase(usuario)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return false;
     }
     public Persona iniciarSesion(String usuario, String clave) {
    try {
        List<String> lines = u.readLines(file_name);
        for (String line : lines) {
            String[] partes = line.split("\t");
            if (partes.length >= 2) {
                String usuarioGuardado = partes[0].trim();
                String claveGuardada = partes[1].trim();

                if (usuarioGuardado.equalsIgnoreCase(usuario.trim()) &&
                    claveGuardada.equals(clave.trim())) {
                    return new Persona(usuarioGuardado, claveGuardada);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return null;
}


  

}
