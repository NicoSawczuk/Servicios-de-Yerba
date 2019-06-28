
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="prestadores")
public class Prestador extends Persona{
    //Atributos

    @ManyToMany(mappedBy = "prestadores")
    private List<Zona> zonas;
    
    @ManyToMany
    private List<Servicio> servicios;
    
    
    @OneToMany(mappedBy = "prestador")
    private List<ServicioPrestador> serviciosPrestador;

    
    public Prestador(){
        this.zonas= new ArrayList<>();
        this.servicios= new ArrayList<>();
        this.serviciosPrestador= new ArrayList<>();
    }

    
    
    public Prestador(String nombre,String cuit, String razonSocial, String numeroInym, String domicilioLegal) {
        super(nombre, cuit, razonSocial, numeroInym, domicilioLegal);
        this.zonas=new ArrayList();
    }

    
    //Getters and Setters

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<ServicioPrestador> getServiciosPrestador() {
        return serviciosPrestador;
    }

    public void setServiciosPrestador(List<ServicioPrestador> serviciosPrestador) {
        this.serviciosPrestador = serviciosPrestador;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    //agregar
    public void AgregarZona(Zona zonas) {
        this.zonas.add(zonas);
        zonas.agregarPrestador(this); 
    }
    
    public void agregarServicioPrestador(ServicioPrestador sp){
        this.serviciosPrestador.add(sp);
    }
    
    public void agregarServicio(Servicio s){
        this.servicios.add(s);
        
    }
    
    
    @Override
    public String toString(){
        return super.getNombre();
    }
    
    
    
    
    
    
    
    
}
