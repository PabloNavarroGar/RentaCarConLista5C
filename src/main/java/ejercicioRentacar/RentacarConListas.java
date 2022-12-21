/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ejercicioRentacar;

/**
 *
 * @author pablo
 */
public class RentacarConListas {

    public static void main(String[] args) {
        CatalogoVehiculos cv = new CatalogoVehiculos(10);
        CatalogoClientes cc = new CatalogoClientes(10);

        System.out.println(cv);

        System.out.println(cc);
        Cliente c = cc.buscarCliente("3");

        System.out.println("Metodo de buscarCliente");
        System.out.println(c);
        System.out.println("-------------------");
        System.out.println("Metodo de buscarVehiculo");
        System.out.println(cv.buscarVehiculo("4"));
    }
}
