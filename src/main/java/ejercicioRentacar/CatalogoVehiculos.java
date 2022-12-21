/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;



/**
 *
 * @author pablo
 */
public class CatalogoVehiculos extends Catalogo<Vehiculo> {

    public CatalogoVehiculos(int tamanio) {

        super(tamanio);//llama al constructor de la clase padre, que es catalogo
            
        for (int i = 0; i < tamanio; i++) {
            this.lista.add(new Vehiculo());
         }

    }

    //Este elemento va en esta clase aparte
    public Vehiculo buscarVehiculo(String bastidor) {

        Vehiculo aux = new Vehiculo();

        aux.setBastidor(bastidor);//Fuerzo a que el cliente tenga el bastidor que busco
        int posicion = this.buscarElemento(aux);

        return (posicion >= 0) ? this.lista.get(posicion) : null;
    }

    
    
}
