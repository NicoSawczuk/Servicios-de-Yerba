
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
    private String cantHectarea;

    
    @ManyToMany
    private List<Servicio> servicios;
    
    
    
    public Productor(String nombre, String cuit, String razonSocial, String numeroInym, String domicilioLegal, String cantHectarea) {
        super(nombre, cuit, razonSocial, numeroInym, domicilioLegal);
        this.cantHectarea=cantHectarea;
    } 
    

    public Productor() {
    }
  
    
    @Override
    public String toString(){
        return super.getNombre();
    }
    
    
}
