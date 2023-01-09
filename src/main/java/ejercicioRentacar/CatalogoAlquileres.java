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
    //Extends llamando al Catalogo principal y le meto adentro el objeto Alquiler
    
    public CatalogoAlquileres(int tamanio) {

        super(tamanio);//Llama al constructor de la clase padre, que es catalogo

    }

    //Este elemento va en esta clase aparte
    public Alquiler buscarAlquiler(int id) {

        Alquiler aux = new Alquiler();

        aux.setAlquierID(id);//Fuerzo a que el alquiler busque con el id
        int posicion = this.buscarElemento(aux);

        return (posicion >= 0) ? this.lista.get(posicion) : null;
    }

    //Devuelve el booleano por lo cual es un metodo que devuelve true y false
    //Meto un bucle for con el size, el cual recorrera y con la condicion de que 
    //segun la lista obtenemos el cliente, y el Nif llamando al cliente, con el String
    //que es el Nif
    public boolean buscarAlquilerPorNif(String nif) {
        boolean resultado = false;
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCliente().getNif().equals(nif)) {
                resultado = true;

            }
        }

        return resultado;

    }
    //Misma descripcion que el metodo de buscarloalquilerpor Nif, solo que ne vez de nif es con el bastidor
    public boolean buscarVehiculoPorBastidor(String bastidor) {

        boolean resultado = false;
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getVehiculo().getBastidor().equals(bastidor)) {
                resultado = true;

            }
        }
        return resultado;

    }
    //Buscar alquiler de vehiculos al ArrayList
    //Creo un metodo public llamando al Arraylist metiendo el alquiler, le doy nombre y le meto un bastidor
    
    public ArrayList<Alquiler> alquiVeh(String bastidor){
        ArrayList <Alquiler> listaNueva = new ArrayList<>();
        //Creo una nueva ArrayList de Alquiler con un nuevo nombre
        //Inicio un bucle for con el size y con la condicion del bastidor, añadimos en
        //la nueva lista la lista que habia
        for (int i = 0; i < this.lista.size(); i++) {
            
            if(lista.get(i).getVehiculo().getBastidor().equals(bastidor)){
                
                listaNueva.add(lista.get(i));
            }
                
        }
        return listaNueva;
    }
    //Mismo proceso que el anterior,solo que en vez de bastidor es con el nif
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
