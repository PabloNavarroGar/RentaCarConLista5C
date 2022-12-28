/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Empresa {

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }

    private String nombre;
    private String cif;
    private CatalogoClientes clientes;
    private CatalogoVehiculos vehiculos;
    private CatalogoAlquileres alquileres;
    private static int contador = 0;

    public Empresa(String nombre) {
        this.cif = String.valueOf(contador++);
        this.nombre = nombre;
        this.vehiculos = new CatalogoVehiculos(10);
        this.clientes = new CatalogoClientes(10);
        this.alquileres = new CatalogoAlquileres(10);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public CatalogoClientes getClientes() {
        return clientes;
    }

    public void setClientes(CatalogoClientes clientes) {
        this.clientes = clientes;
    }

    public CatalogoVehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(CatalogoVehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public CatalogoAlquileres getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(CatalogoAlquileres alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cif);
        return hash;
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
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.cif, other.cif);
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", cif=" + cif + ", clientes=" + clientes + ", vehiculos=" + vehiculos + ", alquileres=" + alquileres + '}';
    }

    public void registrarCliente(Cliente cli) {

        this.clientes.anadirElemento(cli);

    }

    public void registrarVehiculo(Vehiculo v) {

        this.vehiculos.anadirElemento(v);
    }

    public boolean registrarAlquiler(Alquiler a) {

        return this.registrarAlquiler(a);
    }

    public void recibirVehiculo(Alquiler a) {
        a.getVehiculo().setDisponible(true);

    }

    public void registrarAlquiler() {
        Alquiler a = pedirDatosAlquiler();
        if (this.clientes.buscarCliente(a.getCliente().getNif()) != null && this.vehiculos.buscarVehiculoPorBastidor(a.getVehiculo().getBastidor()) != null) {
            if (a.getVehiculo().isDisponible()) {
                a.getVehiculo().setDisponible(false);

                this.alquileres.anadirElemento(a);
            }
        }

    }
    
     public Alquiler pedirDatosAlquiler() {

        String nif = "";
        String bastidor = "";
        int duracion = 0;

        JOptionPane.showMessageDialog(null,"introduzca el nif correspondiente\n"
                );
        nif = JOptionPane.showInputDialog("Introduce el nif del cliente que alquila");

        JOptionPane.showMessageDialog(null, "introduzca el bastridor correspondiente\n"
             );

        bastidor = JOptionPane.showInputDialog("Introduce el bastidor del coche a alquilar");

        duracion = filtrarNumeroEnteroJOptionPane("Indica la duración del alquiler");
        return new Alquiler(clientes.buscarCliente(nif), vehiculos.buscarVehiculoPorBastidor(bastidor), LocalDate.now(), duracion);

    }

    public Cliente buscarClientePorNif(String nif) {

        return this.clientes.buscarCliente(nif);

    }

    //Devolver una lista con todos Alquileres de un vehiculo, usando su bastidor.
    public Vehiculo buscarVehiculoPorBastidor(String bastidor) {

        return this.vehiculos.buscarVehiculoPorBastidor(bastidor);
    }

    //Devolver una lista con todos Alquileres de un vehiculo, usando su bastidor.
    public ArrayList<Alquiler> buscarAlquilerVehiculo(String bastidor) {

        return this.alquileres.alquiVeh(bastidor);
    }

    public ArrayList<Alquiler> buscarAlquilerCliente(String nif) {

        return this.alquileres.alquiVeh(nif);
    }

    public void borrarAlquilerId(int id) {

        this.alquileres.buscarAlquiler(id).getVehiculo().setDisponible(true);
        this.alquileres.lista.remove(this.alquileres.buscarAlquiler(id));
    }

    public void borrarClientesSinAlquiler(String nif) {
        boolean borrar = alquileres.buscarAlquilerPorNif(nif);
        if (!borrar) {
            clientes.borrarElemento(buscarClientePorNif(nif));
        }

    }

    public ArrayList<Vehiculo> obtenerVehiculosConFechaAlquilerTerminados(LocalDate fecha) {

        ArrayList<Vehiculo> vehiculos = new ArrayList() {
        };

        for (Alquiler a : alquileres.lista) {
            if (a.getFechaInicio().plusDays(a.getDuracion()).equals(fecha)) {
                vehiculos.add(a.getVehiculo());
            }

        }

        return vehiculos;
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
