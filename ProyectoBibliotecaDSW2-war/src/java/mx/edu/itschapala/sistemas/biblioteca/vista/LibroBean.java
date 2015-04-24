/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.AutorLibro;
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
     @EJB
    private AutorBLLocal autorBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Libro>lista;
    private Libro libro;//objeto no autoadministrado
    private Accion accion;
    private List<AutorLibro> listaAutorLibro;
    private AutorLibro autorLibro;
    private int autorSeleccionado;//variable para el combo de autor
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

    public AutorLibro getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(AutorLibro autorLibro) {
        this.autorLibro = autorLibro;
    }

    public List<AutorLibro> getListaAutorLibro() {
        return listaAutorLibro;
    }

    public int getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(int autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
public String procesarPeticion(){
    switch(accion){
        case NUEVO:
            libroBL.registrar(libro,listaAutorLibro);
            break;
        case EDITAR:
            libroBL.modificar(libro);
            break;
        case ELIMINAR:
            libroBL.eliminar(libro);
            break;
    }
    accion=Accion.NADA;
    return "LibroListav2";
}

public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "LibroListav2";
    }else{
    return "LibroCrearEditarv2";
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

public void prepararNuevo(ActionEvent e){
    libro=new Libro();
    accion=Accion.NUEVO;
    listaAutorLibro=new ArrayList<>();
    autorLibro=new AutorLibro();
}
public void prepararEditar(ActionEvent e){
    accion=Accion.EDITAR;
}

public void prepararEliminar(ActionEvent e){
    accion=Accion.ELIMINAR;
}

public void agregarAutor(ActionEvent e){
    autorLibro=new AutorLibro();
    autorLibro.setIdAutor(autorBL.getPorId(autorSeleccionado));
    listaAutorLibro.add(autorLibro);
}
}
