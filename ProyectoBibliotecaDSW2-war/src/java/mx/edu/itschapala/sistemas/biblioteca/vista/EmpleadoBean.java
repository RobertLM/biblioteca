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
import mx.edu.itschapala.sistemas.biblioteca.bl.EmpleadoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.bl.PuestoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Empleado;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class EmpleadoBean {
    
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @EJB
    private EmpleadoBLLocal empleadoBL;
    @EJB
    private PuestoBLLocal puestoBL;
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Empleado> lista;
    private Empleado empleado;
    private Accion accion;
    private int puestoSeleccionado;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
        empleado=new Empleado();
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Empleado>getLista(){
    lista=empleadoBL.getLista();
    return lista;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public int getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(int puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }

    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    
    
    public String procesarPeticion(){
        switch(accion){
            case NUEVO:
                empleadoBL.registrar(empleado);
                break;
            case EDITAR:
                empleadoBL.modificar(empleado);
                break;
            case ELIMINAR:
                empleadoBL.eliminar(empleado);
                break;
        }
        accion=Accion.NADA;
        return "EmpleadoListav2";
    }
    
    public String procesarCancelar(){
        if(accion==Accion.ELIMINAR){
            return "EmpleadoListav2";
        }else{
            return "EmpleadoCrearEditarv2";
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

    public void prepararNuevo(ActionEvent e){
        empleado=new Empleado();
        accion=Accion.NUEVO;
    }
    public void prepararEditar(ActionEvent e){
        accion=Accion.EDITAR;
    }
    public void prepararEliminar(ActionEvent e){
        accion=Accion.ELIMINAR;
    }
    
    public void actualizarPuesto(ActionEvent e){
        empleado.setIdPuesto(puestoBL.getPorId(puestoSeleccionado));
    }
    
}
