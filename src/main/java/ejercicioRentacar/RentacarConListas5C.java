/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicioRentacar;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class RentacarConListas5C {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        //Voy a decidir ingresar los datos de los clientes y vehiculos manualmente
        // TODO code application logic here
        //Los metodos de introducir por teclado el cliente,Vehiculo y alquiler estan en la clase de la Empresa.
        //Variables
        int id = 0;
        String opcion = "";
        //Creo 2 catalogos, para poder añadir vehiculos
        CatalogoVehiculos cv = new CatalogoVehiculos(5);
        CatalogoClientes cc = new CatalogoClientes(5);
        CatalogoAlquileres ca = new CatalogoAlquileres(5);

        //Creo la empresa
        Empresa RentaCarEstepona = new Empresa("RentacarPablosEstepona");
        do {

            opcion = pedirNumeroOpcion();

            switch (opcion) {
                case "1":
                    Cliente auxCli = introducirTecladoCliente();

                    System.out.println("-------------------");

                    System.out.println(auxCli);
                    break;
                case "2":

//                    Vehiculo auxVe = introducirTecladoVehiculo();
//                    System.out.println("-------------------");
//                    System.out.println(auxVe);
                    break;
                case "3":

                    RentaCarEstepona.registrarAlquiler();
                    System.out.println("-------------------");

                    System.out.println();
                    break;
                case "4":

                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getClientes());
                    String nif = JOptionPane.showInputDialog(
                            "Introduce el nif del cliente del que queremos obtener los alquileres");
                    JOptionPane.showMessageDialog(null, imprimirLista(RentaCarEstepona.buscarAlquilerCliente(nif)));
                    break;

                case "5":

                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getVehiculos());
                    String bastidor = JOptionPane.showInputDialog(
                            "Introduce el bastidor del vehiculo del que queremos obtener los alquileres");
                    JOptionPane.showMessageDialog(null, imprimirLista(RentaCarEstepona.buscarAlquilerVehiculo(bastidor)));
                    break;

                case "6":

                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getAlquileres());
                    id = filtrarNumeroEnteroJOptionPane("Intruce el"
                            + " id del alquiler del que quieres obtener el vehiculo");
                    RentaCarEstepona.recibirVehiculo(RentaCarEstepona.getAlquileres().buscarAlquiler(id));
                    break;

                case "7":
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getAlquileres());
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getClientes());
                    nif = JOptionPane.showInputDialog(
                            "Introduce el nif del cliente que queremos eliminar");

                    RentaCarEstepona.borrarClientesSinAlquiler(nif);

                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getAlquileres());
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getVehiculos());
                    bastidor = JOptionPane.showInputDialog(
                            "Introduce el nif del cliente que queremos eliminar");
                    RentaCarEstepona.buscarVehiculoPorBastidor(bastidor);

                    break;
                case "9":

                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getAlquileres());
                    LocalDate fecha = LocalDate.now();
                    JOptionPane.showMessageDialog(null, imprimirLista(RentaCarEstepona.obtenerVehiculosConFechaAlquilerTerminados(fecha)));

                    break;
                case "10":
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getClientes());
                    break;
                case "11":
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getVehiculos());
                    break;
                case "12":
                    JOptionPane.showMessageDialog(null, RentaCarEstepona.getAlquileres());
                    break;
            }

        } while (!opcion.equalsIgnoreCase("13"));

    }

    public static String mostrarMenuCodigos() {
        String texto = """
                       RentarCar Estepona
                       ------------------------------
                       Escriba por el numero la opcion que quiere realizar
                       __________________________________________________
                       
                           ¿Que quiere hacer?
                       __________________________________________________                    
                       ----------------------------------------
                         [1]Dar de alta un cliente(registar)
                        ----------------------------------------
                         [2]Dar de alta un Vehiculo(registar)
                        ----------------------------------------
                         [3]Realizar Alquiler(Introduccion de datos) 
                        ----------------------------------------      
                       
                        ----------------------------------------
                         [4]Buscar Alquileres de un Cliente.
                        ----------------------------------------                
                         [5]Buscar Alquileres de un Vehiculo.
                        ----------------------------------------
                         [6]Recibir Vehiculo
                        ---------------------------------------
                       
                       ----------------------------------------
                         [7]Borrar cliente sin Alquiler
                       ----------------------------------------                
                         [8]Borrar Vehiculo sin Alquiler
                       ----------------------------------------
                         [9]Obtener vehiculos que terminan alquiler
                       ---------------------------------------
                       
                       ----------------------------------------
                         [10]Mostar Clientes
                       ----------------------------------------                
                         [11]Mostar Vehiculos
                       ----------------------------------------
                         [12]Mostar Alquileres
                       ----------------------------------------
                       
                       
                       
                       ----------------------------------------
                         [13]Salir del programa.
                        ---------------------------------------
                       """;
        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;
    }

    public static String pedirNumeroOpcion() {
        String codigo;
        do {
            codigo = mostrarMenuCodigos();
        } while (!esCodigoProductoValido(codigo));
        return codigo;
    }

    public static boolean esCodigoProductoValido(String codigo) {

        return (codigo.equalsIgnoreCase("1") || codigo.equalsIgnoreCase("2") || codigo.equalsIgnoreCase("3")
                || codigo.equalsIgnoreCase("4") || codigo.equalsIgnoreCase("5") || codigo.equalsIgnoreCase("6")
                || codigo.equalsIgnoreCase("7") || codigo.equalsIgnoreCase("8") || codigo.equalsIgnoreCase("9")
                || codigo.equalsIgnoreCase("10") || codigo.equalsIgnoreCase("11") || codigo.equalsIgnoreCase("12")
                || codigo.equalsIgnoreCase("13"));
    }

    public static Vehiculo introducirTecladoVehiculo() {
        //creamos objeto de tipo serie

        Vehiculo vehiculo;

        //Leer por teclado e instanciar
        System.out.println("Numero del Bastidor del Vehiculo");
        String bastidorVehiculo = teclado.nextLine();
        System.out.println("Numero Matricula Vehiculo");
        String matriculaVehiculo = teclado.nextLine();
        System.out.println("Color del Vehiculo");
        String colorVehiculo = teclado.nextLine();
        System.out.println("Modelo del Vehiculo");
        String modeloVehiculo = teclado.nextLine();

        //Instancias el objeto
        vehiculo = new Vehiculo(bastidorVehiculo, matriculaVehiculo, colorVehiculo, modeloVehiculo);

        //Devolvemos el tipo serie
        return vehiculo;
    }

    public static Cliente introducirTecladoCliente() {
        //creamos objeto de tipo serie

        Cliente cliente;

        //Leer por teclado e instanciar
        System.out.println("Nombre del cliente");
        String nombreCliente = teclado.nextLine();
        System.out.println("Apellidos del cliente");
        String apellidoCliente = teclado.nextLine();
        System.out.println("Dni del cliente");
        String nifCliente = teclado.nextLine();

        //Instancias el objeto que obtiene el constructo de la clase cliente
        cliente = new Cliente(nombreCliente, apellidoCliente, nifCliente);

        //Devolvemos el tipo serie
        
        return cliente;
    }

    public static String imprimirLista(ArrayList list) {

        String tmp = "";
        for (Object o : list) {
            tmp += o.toString() + "\n";
        }
        return tmp;

    }

    public static int filtrarNumeroEnteroJOptionPane(String msj) {

        int numero = 0;
        boolean seguir = true;
        do {

            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(msj));
                seguir = false;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Ha introducido un valor incorrecto, repita");
            }

        } while (seguir);

        return numero;
    }
    
   

}
