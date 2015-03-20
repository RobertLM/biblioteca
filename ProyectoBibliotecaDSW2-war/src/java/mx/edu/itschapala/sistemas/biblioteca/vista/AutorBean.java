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
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class AutorBean {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @EJB
    private AutorBLLocal autorBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private List<Autor>lista;//Variable con la lista de autores
    private Autor autor;//objeto no autoadministrado
    private Accion accion;//Variable para saber que s va a realizar
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public AutorBean() {
        autor=new Autor();
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public List<Autor> getLista(){
        lista=autorBL.getLista();
        return lista;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public String procesarPeticion(){
        switch(accion){
            case NUEVO:
                 autorBL.registrar(autor);
                 break;
            case EDITAR:
                 autorBL.modificar(autor);
                 break;
            case ELIMINAR:
                 autorBL.eliminar(autor);
                 break;
        }
        accion=Accion.NADA;
        return "AutorLista";
    }
    
    public String procesarCancelar(){
        if(accion==Accion.ELIMINAR){
            return "AutorLista";
        }else{
            return "AutorCrearEditar";
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   
    public void prepararNuevo(ActionEvent e){
        autor=new Autor();
        accion=Accion.NUEVO;
    }
    
    public void prepararEditar(ActionEvent e){
        accion=Accion.EDITAR;
    }
    public void prepararEliminar(ActionEvent e){
        accion=Accion.ELIMINAR;
    }
}
