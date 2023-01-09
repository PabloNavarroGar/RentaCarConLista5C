/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ejercicioRentacar;

import java.util.Random;

/**
 *
 * @author pablo
 */
public enum NombreCliente {
    JUAN,PABLO,MARCOS,TOMAS,SAMUEL,ALBERTO,MIGUEL;
    
   public static NombreCliente getNombreAleatorio(){
       //metodo statico que usamos el nombbre de la clase 
       Random r = new Random();
       //Usamos el nombre de la clase para generar el array y con los valores
       NombreCliente[] nombres = NombreCliente.values();
       //Creamos una variable de tipo int, y usamos la variable random con su nextInt dentro de un origen
       //Sera 0
       int posicion = r.nextInt(0,nombres.length);
       
       return nombres[posicion];
       
   }
}
