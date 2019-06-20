
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

    
    
    public Prestador(int cuit, String razonSocial, int numeroInym, String domicilioLegal) {
        super(cuit, razonSocial, numeroInym, domicilioLegal);
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
    
    @Override
    public String toString(){
        int cui = super.getCuit();
        String cuit = String.valueOf(cui);
        return cuit;
    }
    
    
    
    
    
    
    
    
}
