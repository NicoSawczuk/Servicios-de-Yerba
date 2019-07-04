/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Prestador;
import Modelo.Productor;
import Modelo.Servicio;
import Modelo.ServicioPrestador;
import Modelo.TipoServicio;
import Modelo.Unidad;
import Modelo.Zona;
import dao.Persistencia;
import java.util.ArrayList;
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
        public void agregarTipoServicio(String descripcion, Unidad unidad){
            this.persistencia.iniciarTransaccion();
        try {
            TipoServicio s = new TipoServicio(descripcion.toUpperCase(), unidad);
            this.persistencia.insertar(s);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Tipo de Servicio");
        }
        }
        
        public void agregarServicioPrestador(double costo, TipoServicio tipoServicio, Prestador prestador){
            this.persistencia.iniciarTransaccion();
            try {
                ServicioPrestador sp = new ServicioPrestador(costo, tipoServicio, prestador);
 
                tipoServicio.agregarServicioPrestador(sp);
                prestador.agregarServicioPrestador(sp);
                sp.agregarTipoServicio(tipoServicio);
                sp.setCosto(costo);

                this.persistencia.modificar(tipoServicio);
                this.persistencia.modificar(prestador);
                this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Servicio");
        }
        }
        
        public void agregarServicioProductorPrestador(Prestador pres, Productor prod, TipoServicio tipoServicio,  boolean terminado, boolean cancelado, Date fechaInicio, double costo){
           this.persistencia.iniciarTransaccion();
           try {
            Servicio s = new Servicio(pres,prod,tipoServicio,terminado,cancelado);
            s.setDescripcion(tipoServicio.getDescripcion());
            s.setFechaInicio(fechaInicio);
            s.setCostoTotal(costo);
            prod.agregarServicio(s);
            pres.agregarServicio(s);
            this.persistencia.insertar(s);
            this.persistencia.modificar(prod);
            this.persistencia.modificar(pres);
            this.persistencia.modificar(tipoServicio);
            this.persistencia.confirmarTransaccion();
        }catch (Exception e) {
            System.out.println("ERRRR"+ e.getMessage());
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Servicio");
        }
        }
        
        public void agregarServicio(Prestador pres, Productor prod, TipoServicio tipoServicio,  boolean terminado, boolean cancelado){

           this.persistencia.iniciarTransaccion();
            try {
            Servicio s = new Servicio(pres,prod,tipoServicio,terminado,cancelado);
            s.setDescripcion(tipoServicio.getDescripcion());
            s.agregarPrestador(pres);
            s.agregarProductor(prod);
            prod.agregarServicio(s);
            pres.agregarServicio(s);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Servicio");
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
    
    public void editarTipoServicio(TipoServicio s, String descripcion, Unidad unidad){
        this.persistencia.iniciarTransaccion();
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
    
    public void cancelarServicio(Servicio s, String causa, int unidades){
        this.persistencia.iniciarTransaccion();
        s.setCancelado(true);
        s.setCausa(causa);
        s.calcularCosto(unidades);
        this.persistencia.confirmarTransaccion();
    }
    
    //terminar servicio
    public void termiarServicio(Servicio s, String puntaje, int unidades){
        this.persistencia.iniciarTransaccion();
        s.setTerminado(true);
        s.calcularCosto(unidades);
        s.setPuntajeServicio(puntaje);
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
    
    public List listarServiciosPrestador(){
        ServicioPrestador sp = new ServicioPrestador();
        return (List) sp.getTipoServicio();
    }
    
    public List listaServiciosTerminados(Productor p){
        return p.listarTerminados();
        }
    
    public List listarServiciosEnProceso(Productor p){
        return p.listarEnProceso();
    }
    
    public List listarHistorialPuntajes(Productor p){
        return p.listarPuntajes();
    }
    
    
    
    }


    


    


    


    
    
    
    
    //Insertar
        
