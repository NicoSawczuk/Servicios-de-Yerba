
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="servicios")
public class Servicio {
    @Id
    @SequenceGenerator(name="sec_servicio", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_servicio")
    private int idServicio;
    
    private int tipo;
    private String descripcion;
    private double costoTotal;
    private String causa;
    private String puntajeServicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinal;
    private boolean terminado = false;
    private boolean cancelado = false;
    
    @ManyToOne
    private TipoServicio tipoServicio;
    
    @ManyToMany(mappedBy = "servicios")
    private List<Productor> productores;
    
    @ManyToMany(mappedBy = "servicios")
    private List<Prestador> prestadores;

    public Servicio() {
        this.productores = new ArrayList<>(); 
    }
    
    public Servicio (Prestador pres, Productor prod, TipoServicio tipoServicio,  boolean terminado, boolean cancelado){
        this.tipo= tipoServicio.getTipoServicio();
        this.descripcion=descripcion;
        this.fechaInicio=new Date();
        this.terminado=false;
        this.cancelado=false;
        this.tipoServicio=tipoServicio;
        tipoServicio.getServicios().add(this);
    }
    
    //Getters and Setters

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getPuntajeServicio() {
        return puntajeServicio;
    }

    public void setPuntajeServicio(String puntajeServicio) {
        this.puntajeServicio = puntajeServicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
    //Agregar
    public void agregarProductor(Productor p){
        this.productores.add(p);
        p.agregarServicio(this);
    }
    public void agregarPrestador(Prestador p){
        this.prestadores.add(p);
        p.agregarServicio(this);
    }
    

    
    public String toString(){
        return this.descripcion;
    }
    
    
}
