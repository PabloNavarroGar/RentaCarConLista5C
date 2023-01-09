/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author tomas
 */
public class Vehiculo {

    private String bastidor;
    private String matricula;
    private Color color;
    private Modelo modelo;
    private boolean disponible;
    private double tarifa;
    private static int contador = 0;
    private String color2;
    private String modelo2;
    //Constructor sin parametros que genere vehicuos diferentes con datos diferentes
    //FALTA METER EN EL POM LAS DEPENDECIAS CORRESPONDIENTES. 

    public Vehiculo() {

        this.bastidor = String.valueOf(++contador);
        this.matricula = RandomStringUtils.randomNumeric(4);
        this.modelo = Modelo.getAleatorio();
        this.color = Color.getAleatorio();
        this.disponible = true;
    }

    public Vehiculo(String bastidor, String matricula, String color, String modelo) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.color2 = color;
        this.modelo2 = modelo;
        this.disponible = true;

    }

    @Override
    public String toString() {
        return "Vehiculo{" + "bastidor=" + bastidor + ", matricula=" + matricula + ", color=" + color + ", modelo=" + modelo + ", disponible=" + disponible + ", tarifa=" + tarifa + '}';
    }

    //Getters and Setters
    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public Color getColor() {
        return color;
    }

    public Modelo getModelo() {
        return modelo;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.bastidor);
        hash = 83 * hash + Objects.hashCode(this.matricula);
        hash = 83 * hash + Objects.hashCode(this.color);
        hash = 83 * hash + Objects.hashCode(this.modelo);
        hash = 83 * hash + (this.disponible ? 1 : 0);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.tarifa) ^ (Double.doubleToLongBits(this.tarifa) >>> 32));
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.bastidor, other.bastidor);
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getModelo2() {
        return modelo2;
    }

    public void setModelo2(String modelo2) {
        this.modelo2 = modelo2;
    }

    
}
