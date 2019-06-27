
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="tipos_servicios")
public class TipoServicio {
    //Atributos
    @Id
    @SequenceGenerator(name="sec_TipoServicio", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_TipoServicio")
    private int tipoServicio;
    private String descripcion;
    
    @OneToMany (mappedBy ="tipoServicio")
    private List<Servicio> servicios;
    
    @OneToMany(mappedBy="tipoServicio")
    private List<ServicioPrestador> serviciosPrestador;
    
    @OneToOne
    private Unidad unidad;
   
    

    public TipoServicio() {
        this.servicios=new ArrayList<>();
        
    }
    
    public TipoServicio( String descripcion, Unidad unidad){
 
        this.descripcion=descripcion;
        this.unidad=unidad;
        this.servicios=new ArrayList<>();
    }
    
    //Getters and Setters

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

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
    
    
    //agregar
    
    public void agregarServicioPrestador(ServicioPrestador sp){
        this.serviciosPrestador.add(sp);
        sp.agregarTipoServicio(this);
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
    
    
    
    
}
