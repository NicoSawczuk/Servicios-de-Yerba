
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
        this.servicios=new ArrayList<>();
    } 
    

    public Productor() {
        this.servicios=new ArrayList<>();
    }
    
    //Getters and Setters
    public String getCantHectarea() {
        return cantHectarea;
    }

    public void setCantHectarea(String cantHectarea) {
        this.cantHectarea = cantHectarea;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    //Agregar
    public void agregarServicio(Servicio s){
        this.servicios.add(s);
        
    }
    
    //listar terminados
    public List listarTerminados(){
        ArrayList<Servicio> serv = new ArrayList<Servicio>();
        for (int i = 0; i< servicios.size(); i++) {
            Servicio auxT = servicios.get(i);
            if (auxT.isTerminado()!=false){
                serv.add(auxT);
            }
        }
        return serv;
    }
    
    public List listarCancelados(){
        ArrayList<Servicio> serv = new ArrayList<Servicio>();
        for (int i = 0; i< servicios.size(); i++) {
            Servicio auxT = servicios.get(i);
            if (auxT.isCancelado()!=false){
                serv.add(auxT);
            }
        }
        return serv;
    }
    
    public List listarEnProceso(){
        ArrayList<Servicio> serv = new ArrayList<Servicio>();
        for (int i = 0; i< servicios.size(); i++) {
            Servicio auxT = servicios.get(i);
            if (auxT.isCancelado()!=true && auxT.isTerminado()!=true){
                serv.add(auxT);
            }
        }
        return serv;
    }
    
    
    //metodo obtener puntajes
    public List listarPuntajes(){
        ArrayList<String> puntajes = new ArrayList<String>();
        for (int i = 0; i< servicios.size(); i++) {
            Servicio auxT = servicios.get(i);
            if (auxT.isTerminado()!=false){
                puntajes.add(auxT.getPuntajeServicio());
            }
        }
        return puntajes;
    }
  
    
    @Override
    public String toString(){
        return super.getNombre();
    }
    
    
}
