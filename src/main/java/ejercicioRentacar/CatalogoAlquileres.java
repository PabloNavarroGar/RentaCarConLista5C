/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class CatalogoAlquileres extends Catalogo<Alquiler> {

    public CatalogoAlquileres(int tamanio) {

        super(tamanio);//llama al constructor de la clase padre, que es catalogo

    }

    //Este elemento va en esta clase aparte
    public Alquiler buscarAlquiler(int id) {

        Alquiler aux = new Alquiler();

        aux.setAlquierID(id);//Fuerzo a que el alquiler busque con el id
        int posicion = this.buscarElemento(aux);

        return (posicion >= 0) ? this.lista.get(posicion) : null;
    }

    public boolean buscarAlquilerPorNif(String nif) {
        boolean resultado = false;
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCliente().getNif().equals(nif)) {
                resultado = true;

            }
        }

        return resultado;

    }

    public boolean buscarVehiculoPorBastidor(String bastidor) {

        boolean resultado = false;
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getVehiculo().getBastidor().equals(bastidor)) {
                resultado = true;

            }
        }
        return resultado;

    }
    //Añadir alquiler de vehiculos al Array.
    public ArrayList<Alquiler> alquiVeh(String bastidor){
        ArrayList <Alquiler> listaNueva = new ArrayList<>();
        
        for (int i = 0; i < this.lista.size(); i++) {
            
            if(lista.get(i).getVehiculo().getBastidor().equals(bastidor)){
                
                listaNueva.add(lista.get(i));
            }
                
        }
        return listaNueva;
    }
    
    public ArrayList<Alquiler> alquiCli(String nif){
        ArrayList <Alquiler> listaNueva = new ArrayList<>();
        
        for (int i = 0; i < this.lista.size(); i++) {
            
            if(lista.get(i).getCliente().getNif().equals(nif)){
                
                listaNueva.add(lista.get(i));
            }
                
        }
        return listaNueva;
    }

}
