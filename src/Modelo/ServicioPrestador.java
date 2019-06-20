
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="servicios_prestador")
public class ServicioPrestador {
    @Id
    private int id;
    private double costo;
   
    @ManyToOne
    private TipoServicio tipoServicio;
    
    @ManyToOne
    private Prestador prestador;
   

    public ServicioPrestador() {
    }
    
    
}
