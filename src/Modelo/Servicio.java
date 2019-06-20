
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table (name="servicios")
public class Servicio {
    @Id
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
    
    @OneToOne
    private TipoServicio tipoServicio;
    
    @ManyToMany(mappedBy = "servicios")
    private List<Productor> productores;
    
    @ManyToMany(mappedBy = "servicios")
    private List<Prestador> prestadores;

    public Servicio() {
        this.productores = new ArrayList<>();
        
        
    }
    
    
}
