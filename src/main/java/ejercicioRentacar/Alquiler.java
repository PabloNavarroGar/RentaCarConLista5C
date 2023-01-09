/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

import java.time.LocalDate;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author pablo
 */
public class Alquiler {
    
    private int alquierID;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private int duracion;
   
  
    private static int contador=0;
    public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, int duracion) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        contador++;
        this.alquierID=contador;
    }
    //Creo un constructor vacio, para cuando use en el catalogodeAquilieres
    public Alquiler() {
       
        this.cliente = new Cliente();
        this.vehiculo = new Vehiculo();
        this.fechaInicio = LocalDate.now();
        this.duracion = numeroEnteroRandom(1, 100);
        contador++;
        this.alquierID = contador;
    }
    


    
    public int getAlquierID() {
        return alquierID;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setAlquierID(int alquierID) {
        this.alquierID = alquierID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alquiler{");
        sb.append("alquierID=").append(alquierID);
        sb.append(", cliente=").append(cliente);
        sb.append(", vehiculo=").append(vehiculo.getBastidor());
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.alquierID;
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
        final Alquiler other = (Alquiler) obj;
        return this.alquierID == other.alquierID;
    }
            
     public static int numeroEnteroRandom(int minimo, int maximo) {

        Random random = new Random();
        int numero = random.nextInt(maximo - minimo + 1) + minimo;
        return numero;
    }

}
