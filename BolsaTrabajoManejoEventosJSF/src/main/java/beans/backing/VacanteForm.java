package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Definimos la clase como bean y alcance Request
@Named
@RequestScoped
public class VacanteForm {

    //Inyectamos la dependencia usando el concepto de CDI
    @Inject
    private Candidato candidato;
    
    private boolean comentarioEnviado;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando la VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
        public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }


    public String enviar() {
        if (this.candidato.getNombre().equalsIgnoreCase("juan")) {
            if (this.candidato.getApellido().equalsIgnoreCase("perez")) {
                String msg = "Gracias, pero juan perez ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; //este es un mensaje global
                facesContext.addMessage(componentId, facesMessage);
                return "index";

            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }

    }
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        
        //llama el contexto de la vista (jsf) y captura el cambio de evento 
        
        FacesContext facesContext =  FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
       
        //si conincide el cambio de valor pone el valor de los campos localidad y cuidad
        //en el contexto de la vista y renderiza mostrando los cambios
        
        if("1882".equals(nuevoCodigoPostal)){
            UIInput localidadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:localidad");
            String nuevaLocalidad = "Ezpeleta";
            localidadInputText.setValue(nuevaLocalidad);
            localidadInputText.setSubmittedValue(nuevaLocalidad);
 
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaCiudad = "Quilmes";
            ciudadInputText.setValue(nuevaCiudad);
            ciudadInputText.setSubmittedValue(nuevaCiudad);
            
            facesContext.renderResponse();
 
        }
    }

    public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado = !this.comentarioEnviado;
    }
    
}
