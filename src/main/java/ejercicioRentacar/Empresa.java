/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRentacar;

/**
 *
 * @author pablo
 */
public class Empresa {
    private String nombre;
    private String cif;
    private CatalogoClientes cc;
    private CatalogoVehiculos cv;
    private CatalogoAlquileres ca;

    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.cv = new CatalogoVehiculos(100);
        this.cc = new CatalogoClientes(100);
        this.ca = new CatalogoAlquileres(100);
    }
          
    public void registrarCliente(Cliente cli){
        
        this.cc.anadirElemento(cli);
        
    }
    
    public void registrarVehiculo(Vehiculo v){
        
        
        this.cv.anadirElemento(v);
    }
    
    public boolean registrarAlquiler (Alquiler a){
        
        
        return this.registrarAlquiler(a);
    }
    
    public boolean registrarAlquiler (String nif,String Bastidor,int nDias ){
        
        return true;
    }
    
    
    
    public Cliente buscarCliente(String nif){
        
        return this.cc.buscarCliente(nif);
        
    }
    
    public Vehiculo buscarVehiculo(String bastidor){
        
         return this.cv.buscarVehiculo(bastidor);
    }
    
    
    
     public Alquiler buscarAlquilerPorNif(String nif) {

         return this.ca.buscarAlquilerPorNif(nif);

    }
    
}
