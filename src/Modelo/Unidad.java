
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="unidades")
public class Unidad {
    //Atributos
    @Id
    @SequenceGenerator(name="sec_Unidad", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_Unidad")
    private int tipoUnidad;
    private String descripcion;
    
    
    @OneToOne
    private TipoServicio tipoServicio;

    public Unidad() {
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
    
    
    
}
