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
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class LibroBean {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @EJB
    private LibroBLLocal libroBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Libro>lista;
    private Libro libro;
    private Accion accion;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {
        libro=new Libro();
    }
    
    public List<Libro>getLista(){
    lista=libroBL.getLista();
    return lista;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
public String procesarPeticion(){
    switch(accion){
        case NUEVO:
            libroBL.registrar(libro);
            break;
        case EDITAR:
            libroBL.modificar(libro);
            break;
        case ELIMINAR:
            libroBL.eliminar(libro);
            break;
    }
    accion=Accion.NADA;
    return "LibroLista";
}

public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "LibroLista";
    }else{
    return "LibroCrearEditar";
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

public void prepararNuevo(ActionEvent e){
    libro=new Libro();
    accion=Accion.NUEVO;
}
public void prepararEditar(ActionEvent e){
    accion=Accion.EDITAR;
}

public void prepararEliminar(ActionEvent e){
    accion=Accion.ELIMINAR;
}
}
