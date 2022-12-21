/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

/**
 *
 * @author pablo
 */
public class CatalogoAlquileres extends Catalogo<Alquiler> {

    public CatalogoAlquileres(int tamanio) {

        super(tamanio);//llama al constructor de la clase padre, que es catalogo

        for (int i = 0; i < tamanio; i++) {
            this.lista.add(new Alquiler());//Para que cree el catalago de alquiler
        }
    }

    //Este elemento va en esta clase aparte
    public Alquiler buscarAlquiler(int id) {

        Alquiler aux = new Alquiler();

        aux.setAlquierID(id);//Fuerzo a que el alquiler busque con el id
        int posicion = this.buscarElemento(aux);

        return (posicion >= 0) ? this.lista.get(posicion) : null;
    }

    public Alquiler buscarAlquilerPorNif(String nif) {

        Alquiler aux = new Alquiler();
        //For eeach que le paso la lista, y el objeto Alquier.
        //Si el nif equivale al cliente con sunif, me devuleve el cliente
        for (Alquiler a : this.lista) {
            if (nif.equals(a.getCliente().getNif())) {
                return a;
            }
        }

        return aux;

    }
}
