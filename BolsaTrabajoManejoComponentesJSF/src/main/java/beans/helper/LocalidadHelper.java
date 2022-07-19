/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.helper;

import beans.model.Localidad;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author benja
 */
@Named
@RequestScoped
public class LocalidadHelper {

    public List<Localidad> getLocalidades() {
        List<Localidad> localidades = new ArrayList<>();

        int localidadId = 1;
        Localidad localidad = new Localidad(localidadId++, "Ezpeleta", 1882);
        localidades.add(localidad);

        localidad = new Localidad(localidadId++, "Solano", 1862);
        localidades.add(localidad);

        localidad = new Localidad(localidadId++, "Bernal", 1776);
        localidades.add(localidad);

        return localidades;
    }

    public int getLocalidadPorNombre(String nombre) {
        int localidadId = 0;

        List<Localidad> localidades = this.getLocalidades();
        for (Localidad loc : localidades) {
            if (loc.getNombreLocalidad().equalsIgnoreCase(nombre)) {
                localidadId = loc.getLocalidadId();
                break;
            }
        }
        return localidadId;
    }

    public int getLocalidadIdPorCodigoPostal(int codigoPostal) {
        int localidadId = 0;

        List<Localidad> localidades = this.getLocalidades();
        for (Localidad loc : localidades) {
            if (loc.getCodigoPostal() == codigoPostal) {
                localidadId = loc.getLocalidadId();
                break;
            }
        }
        return localidadId;
    }

    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        List<Localidad> localidades = this.getLocalidades();
        for(Localidad loc: localidades){
            SelectItem si = new SelectItem(loc.getLocalidadId(), loc.getNombreLocalidad());
            selectItems.add(si);
        }
        return selectItems;
    }
}
