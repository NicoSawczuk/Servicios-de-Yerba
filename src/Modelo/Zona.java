
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="zonas")
public class Zona {
    //Atributos
    @Id
    @SequenceGenerator(name="sec_Zona", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_Zona")
    private int idZona;
    private String descripcion;
    
    
    @ManyToMany
    private List<Prestador> prestadores;

    public Zona() {
        this.prestadores = new ArrayList<>();
    }
    
    
    //Getters and Setters

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public void agregarPrestador(Prestador prestador){
        this.prestadores.add(prestador);
    }
    
    
    @Override
    public String toString(){
        
        return this.descripcion;
    }
    
    
    
    
   
    
    
}
