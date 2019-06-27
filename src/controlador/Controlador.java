/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Prestador;
import Modelo.Productor;
import Modelo.Servicio;
import Modelo.TipoServicio;
import Modelo.Unidad;
import Modelo.Zona;
import dao.Persistencia;
import java.util.Date;
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
    public void agregarPrestador(String nombre,String cuit, String razonSocial, String numeroInym, String domicilioLegal){
        this.persistencia.iniciarTransaccion();
        try {
            Prestador p = new Prestador(nombre.toUpperCase(), cuit.toUpperCase(), razonSocial.toUpperCase(), numeroInym, domicilioLegal.toUpperCase());
            this.persistencia.insertar(p);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Prestador");
        }
    }
    
    public void agregarZonaPrestador(Prestador p, Zona z){
        this.persistencia.iniciarTransaccion();
        p.AgregarZona(z);
        this.persistencia.modificar(z);
        this.persistencia.modificar(p);
        this.persistencia.confirmarTransaccion();
    }
    
    
    public void agregarProductor(String nombre,String cuit, String razonSocial, String numeroInym, String domicilioLegal, String cantHectarea){
        this.persistencia.iniciarTransaccion();
        try {
        Productor p = new Productor(nombre.toUpperCase(), cuit.toUpperCase(), razonSocial.toUpperCase(), numeroInym, domicilioLegal.toUpperCase(), cantHectarea);
        this.persistencia.insertar(p);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Productor");
        }
    
    }
        public void agregarTipoServicio(double costo, String descripcion, Unidad unidad){
            this.persistencia.iniciarTransaccion();
        try {
            TipoServicio s = new TipoServicio(costo, descripcion.toUpperCase(), unidad);
            this.persistencia.insertar(s);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Tipo de Servicio");
        }
        }
        

    //Editar
    public void editarPrestador(Prestador p, String nombre,String cuit, String razonSocial, String numeroInym, String domicilioLegal){
        this.persistencia.iniciarTransaccion();
        p.setCuit(cuit);
        p.setDomicilioLegal(domicilioLegal.toUpperCase());
        p.setNombre(nombre.toUpperCase());
        p.setNumeroInym(numeroInym);
        p.setRazonSocial(razonSocial.toUpperCase());
        this.persistencia.modificar(p);
        this.persistencia.confirmarTransaccion();
    }
    
    public void editarTipoServicio(TipoServicio s, double costo, String descripcion, Unidad unidad){
        this.persistencia.iniciarTransaccion();
        s.setCosto(costo);
        s.setDescripcion(descripcion.toUpperCase());
        s.setUnidad(unidad);
        this.persistencia.confirmarTransaccion();
    }
    
    public void editarProductor(Productor p, String nombre, String cuit, String razonSocial, String numeroInym, String domicilioLegal, String cantHectarea){
        this.persistencia.iniciarTransaccion();
        p.setNombre(nombre.toUpperCase());
        p.setCuit(cuit);
        p.setRazonSocial(razonSocial.toUpperCase());
        p.setNumeroInym(numeroInym);
        p.setDomicilioLegal(domicilioLegal.toUpperCase());
        p.setCantHectarea(cantHectarea);
        this.persistencia.confirmarTransaccion();
    }
        
    
    
    
    //Eliminar
    public int eliminarPrestador(Prestador p){
        if (p.getZonas().isEmpty()){
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(p);
            this.persistencia.confirmarTransaccion();
            return 0;
        }
        else {
            return 1;
        }
        }
     public int eliminarTipoServicio(TipoServicio s){
        //verificamos que el TipoServicio que queremos eliminar  no tenga servicios asociados 
         if (s.getServicios().isEmpty() && s.getServiciosPrestador().isEmpty()){
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(s);
            this.persistencia.confirmarTransaccion();
            return 0;
        }
        else {
            return 1;
        }
     }
     
         public int eliminarProductor(Productor p){
             //verificamos que el productor que queremos eliminar no tenga servicios contratados
            if (p.getServicios().isEmpty()){
                this.persistencia.iniciarTransaccion();
                this.persistencia.eliminar(p);
                this.persistencia.confirmarTransaccion();
                return 0;
            }
            else {
                return 1;
            }
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
    
    public List listarServicios(){
        return this.persistencia.buscarTodos(Servicio.class);
    }
}
    
    
    
    
    //Insertar
        
