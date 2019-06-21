
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
    private double costo;
    private String descripcion;
    
    @OneToOne
    private Servicio servicio;
    
    @OneToMany(mappedBy="tipoServicio")
    private List<ServicioPrestador> serviciosPrestador;
    
    @OneToOne
    private Unidad unidad;
   
    

    public TipoServicio() {
        
    }
    
    public TipoServicio(double costo, String descripcion, Unidad unidad){
        //falta agregar la pta unidad motherfucker shit hostia chaval pringao
        this.costo=costo;
        this.descripcion=descripcion;
        this.unidad=unidad;
    }
    
    //Getters and Setters

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    @Override
    public String toString(){
        return this.descripcion;
    }
    
    
    
    
}
