/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

//Definimos la clase como bean y alcance Request
@Named
@RequestScoped
public class VacanteForm {
    
    //Inyectamos la dependencia usando el concepto de CDI
    @Inject
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(this.candidato.getNombre().equals("juan")){
            return "exito";
        } else {
           return  "fallo";
        }
            
    }
    
}
