/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.model;

/**
 *
 * @author benja
 */
public class Localidad {
    
    private int localidadId;
    private String nombreLocalidad;
    private int codigoPostal;

    public Localidad(int localidadId, String nombreLocalidad, int codigoPostal) {
        this.localidadId = localidadId;
        this.nombreLocalidad = nombreLocalidad;
        this.codigoPostal = codigoPostal;
    }

    public Localidad() {
    }

    public int getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(int localidadId) {
        this.localidadId = localidadId;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
          
    
}
