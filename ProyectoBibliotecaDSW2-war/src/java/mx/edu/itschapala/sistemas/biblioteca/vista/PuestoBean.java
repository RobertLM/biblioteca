/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.edu.itschapala.sistemas.biblioteca.bl.PuestoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesto;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class PuestoBean {
    @EJB
    private PuestoBLLocal puestoBL;

    private List<Puesto>lista;
    /**
     * Creates a new instance of PuestoBean
     */
    public PuestoBean() {
    }
    
    public List<Puesto>getLista(){
    lista=puestoBL.getLista();
    return lista;
    }
}
