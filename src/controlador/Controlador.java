/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Prestador;
import Modelo.Productor;
import Modelo.TipoServicio;
import Modelo.Unidad;
import Modelo.Zona;
import dao.Persistencia;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nico2
 */
public class Controlador {
    Persistencia persistencia;

    public Controlador(Persistencia persistencnia) {
        this.persistencia = persistencnia;
    }
    
    
    
    //Agregar
    public void agregarPrestador(int cuit, String razonSocial, int numeroInym, String domicilioLegal){
        this.persistencia.iniciarTransaccion();
        Prestador p = new Prestador(cuit, razonSocial.toUpperCase(), numeroInym, domicilioLegal.toUpperCase());
        this.persistencia.insertar(p);
        
        this.persistencia.confirmarTransaccion();
    }
    
    public void agregarProductor(int cuit, String razonSocial, int numeroInym, String domicilioLegal, double cantHectarea){
        this.persistencia.iniciarTransaccion();
        
        Productor p = new Productor(cuit, razonSocial.toUpperCase(), numeroInym, domicilioLegal.toUpperCase(), cantHectarea);
        this.persistencia.insertar(p);
        
        this.persistencia.confirmarTransaccion();
    
    }
        public void agregarTipoServicio(double costo, String descripcion){
            this.persistencia.iniciarTransaccion();
            
            TipoServicio s = new TipoServicio(costo, descripcion.toUpperCase());
            this.persistencia.insertar(s);
            
            this.persistencia.confirmarTransaccion();
            
            
        }
        
    
    //Listar
    public List listarPrestadores(){
        return this.persistencia.buscarTodos(Prestador.class);
    }
    
    public List listarProductores(){
        return this.persistencia.buscarTodos(Productor.class);
    }
    
    public List listarZonas(){
        return this.persistencia.buscarTodos(Zona.class);
    }
    
    public List listarUnidades(){
        return this.persistencia.buscarTodos(Unidad.class);
    }
    
    public List listarTiposServicios(){
        return this.persistencia.buscarTodos(TipoServicio.class);
    }
    
    
    
    
    //Insertar
    
}
