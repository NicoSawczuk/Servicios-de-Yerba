
package Modelo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public abstract class Persona {
    //Atributos
    @Id
    private int cuit;
    private String razonSocial;
    private int numeroInym;
    private String domicilioLegal;

    public Persona() {
    }

    
    
    public Persona(int cuit, String razonSocial, int numeroInym, String domicilioLegal) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.numeroInym = numeroInym;
        this.domicilioLegal = domicilioLegal;
    }
    
    //Getters and Setters

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNumeroInym() {
        return numeroInym;
    }

    public void setNumeroInym(int numeroInym) {
        this.numeroInym = numeroInym;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }
    
    

    
    
    
    
}
