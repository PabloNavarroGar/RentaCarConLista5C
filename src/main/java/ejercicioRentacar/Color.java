/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ejercicioRentacar;

import java.util.Random;

/**
 *
 * @author tomas
 */
public enum Color {
    ROJO, AZUL, AMARILLO;
    //Metodo para escoger entre los 3 colore que hay , va con el objeto de Vehiculo
    public static Color getAleatorio(){
        Random r = new Random();
        //Generá un array de todos los colores del enum. 
        Color[] colores = Color.values();

        int posicion = r.nextInt(0,colores.length);
        //Devuelvo el color segun la posición en la que este el numero random
        return colores[posicion];
    }
    
}
