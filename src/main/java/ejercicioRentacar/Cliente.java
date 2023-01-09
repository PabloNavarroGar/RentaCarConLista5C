/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author pablo
 */
public class Cliente {

    private NombreCliente nombre;
    private String apellidos;
    private String nif;
    private NombreCliente nombreAleatorio;
    private String nombre2;
    private static int contador = 0;
    
    public Cliente() {
        this.nombre = NombreCliente.getNombreAleatorio();
        this.apellidos = RandomStringUtils.randomAlphabetic(3);
        contador++;
        this.nif = String.valueOf(contador);
    }
//    Constructor el cual se introduce los datos que le pasemos, es el que usamos por teclado
    public Cliente(String nombre, String apellidos, String nif) {
        this.nombre2 = nombre;
        this.apellidos = apellidos;

        this.nif = nif;

    }

   
    
    

    public NombreCliente getNombre() {
        return nombre;
    }

//    private static String generarNIF() {
//        //Declaramos los char de las letras
//
//        //Generamos una char poniendo en orden las letras
//        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
//        //Usamos las dependecias lag para seleccionar la funcion del  random con 8 digittos
//        String nif = RandomStringUtils.randomNumeric(8);
//        //Declaramos el nif y numero de letra
//        int nifnumero;
//
//        int numeroLetra;
//        //System.out.println("El numero generados son: " + numero);
//        //Hacemos parse para equivaler el String con el int
//        nifnumero = Integer.parseInt(nif);
//        //Tengo el nif con el parse del numero
//        //division del nif entre 23 
//        numeroLetra = nifnumero % 23;
//
//       
//        //devuelvo el String del numero aleatorio junto con el char letra y el numero de la letra
//        return nif + letras[numeroLetra];
    //}
    //Getter y Setters
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
    public void setNombre(NombreCliente nombre) {
        this.nombre = nombre;
    }

    public NombreCliente getNombreAleatorio() {
        return nombreAleatorio;
    }

   
    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre +  ", apellidos=" + apellidos + ", nif=" + nif + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.nif, other.nif);
    }

        
}
