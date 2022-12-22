/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicioRentacar;

import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class RentacarConListas {

    public static void main(String[] args) {
        
        Empresa e1 = new Empresa("Rentacar", "123");
        CatalogoVehiculos cv = new CatalogoVehiculos(10);
        CatalogoClientes cc = new CatalogoClientes(10);
        CatalogoAlquileres ca = new CatalogoAlquileres(100);
        Catalogo cata = new Catalogo(30);

        System.out.println("CATALOGO DE VEHICULOS");

        System.out.println(cv);
        
        System.out.println("CATALOGO DE CLIENTES");
        
        System.out.println(cc);

        
       
        
        
        
       
        
        
        
      
        
    
        
        
        
        
       
        
        
        
    }
}
