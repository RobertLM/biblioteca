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
import javax.faces.event.ActionEvent;
import mx.edu.itschapala.sistemas.biblioteca.bl.PuestoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesto;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class PuestoBean {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @EJB
    private PuestoBLLocal puestoBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Puesto>lista;
    private Puesto puesto;
    private Accion accion;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance of PuestoBean
     */
    public PuestoBean() {
        puesto=new Puesto();
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Puesto>getLista(){
    lista=puestoBL.getLista();
    return lista;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    public String procesarPeticion(){
        switch(accion){
            case NUEVO:
                puestoBL.registrar(puesto);
                break;
            case EDITAR:
                puestoBL.modificar(puesto);
                break;
            case ELIMINAR:
                puestoBL.eliminar(puesto);
        }
        accion=Accion.NADA;
        return "PuestoListav2";
    }
    
    public String procesarCancelar(){
        if(accion==Accion.ELIMINAR){
            return "PuestoListav2";
        }else{
            return "PuestoCrearEditarv2";
        }
    }
    

//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

    public void prepararNuevo(ActionEvent e){
        puesto=new Puesto();
        accion=Accion.NUEVO;
    }
    
    public void prepararEditar(ActionEvent e){
        accion=Accion.EDITAR;
    }
    
    public void prepararEliminar(ActionEvent e){
        accion=Accion.ELIMINAR;
    }
    
}
