package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/*@Named notacion cd CDI para managed bean 
  @RequestScoped alcance de tipo request  
*/
@Named
@RequestScoped
public class Candidato {
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}
