
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productores")
public class Productor extends Persona{
    //Atributos
    private double cantHectarea;

    
    @ManyToMany
    private List<Servicio> servicios;
    
    
    
    public Productor(int cuit, String razonSocial, int numeroInym, String domicilioLegal, double cantHectarea) {
        super(cuit, razonSocial, numeroInym, domicilioLegal);
        this.cantHectarea=cantHectarea;
    } 
    

    public Productor() {
    }
  
    
    @Override
    public String toString(){
        int g = super.getCuit();
        String cuit = String.valueOf(g);
        
        return cuit;
    }
    
    
}
