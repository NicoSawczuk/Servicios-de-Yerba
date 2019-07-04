
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="servicios_prestador")
public class ServicioPrestador {
    @Id
    @SequenceGenerator(name="sec_ServicioPrestador", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_ServicioPrestador")
    private int id;
    private double costo;
   
    @ManyToOne
    private TipoServicio tipoServicio;
    
    @ManyToOne
    private Prestador prestador;
   

    public ServicioPrestador(double costo, TipoServicio tipoServicio, Prestador prestador) {
        this.costo=costo;
        this.tipoServicio=tipoServicio;
        this.prestador=prestador;
    }

    public ServicioPrestador() {
    }
    
    //Getters and Setters

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
    
    //agregar
    public void agregarPrestador(Prestador p){
        this.prestador=p;
        p.agregarServicioPrestador(this);
    }
    
    public void agregarTipoServicio(TipoServicio ts){
        this.tipoServicio=ts;
    }
    
    @Override
    public String toString (){
        return prestador.getNombre();
    }
}
