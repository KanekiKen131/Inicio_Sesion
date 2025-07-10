/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controller.InicioSesion;

/**
 *
 * @author alexa
 */
public class Ejecutor {
     public static void main(String[] args) {
         InicioSesion i = new InicioSesion();
        if (i.guardar_usuario("Leonel", "54321")){
            
            System.out.println("Se ha guardado correctamente");
        }else
            System.out.println("Se ha presentado un error"); 
} 
    
}
