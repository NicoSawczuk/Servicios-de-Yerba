package Sistema;

import controlador.Controlador;
import dao.Persistencia;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import vista.ventanaPrincipal;

public class Main {
    public static void main (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegradorPU");
        
        Persistencia p = new Persistencia(emf);
        Controlador c = new Controlador(p);
        ventanaPrincipal v1 = new ventanaPrincipal(c);
        
    }
}
