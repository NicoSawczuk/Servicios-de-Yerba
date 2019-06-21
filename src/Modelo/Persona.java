
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
    private String cuit;
    private String razonSocial;
    private String numeroInym;
    private String domicilioLegal;

    public Persona() {
    }

    
    
    public Persona(String cuit, String razonSocial, String numeroInym, String domicilioLegal) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.numeroInym = numeroInym;
        this.domicilioLegal = domicilioLegal;
    }
    
    //Getters and Setters

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumeroInym() {
        return numeroInym;
    }

    public void setNumeroInym(String numeroInym) {
        this.numeroInym = numeroInym;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }
    
    

    
    
    
    
}
