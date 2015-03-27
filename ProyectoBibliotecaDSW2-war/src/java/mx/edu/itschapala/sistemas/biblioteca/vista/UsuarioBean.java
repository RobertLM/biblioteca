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
import mx.edu.itschapala.sistemas.biblioteca.bl.UsuarioBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Usuario;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @EJB
    private UsuarioBLLocal usuarioBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Usuario>lista;
    private Usuario usuario;
    private Accion accion;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuario=new Usuario();
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    public List<Usuario>getLista(){
    lista=usuarioBL.getLista();
    return lista;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------

    public String procesarPeticion(){
     switch(accion){
         case NUEVO:
             usuarioBL.registrar(usuario);
             break;
         case EDITAR:
             usuarioBL.modificar(usuario);
             break;
         case ELIMINAR:
             usuarioBL.eliminar(usuario);
             break;
     }
     accion=Accion.NADA;
     return "UsuarioLista";
    }
    
    public String procesarCancelar(){
        if(accion==Accion.ELIMINAR){
            return "UsuarioLista";
        }else{
            return "UsuarioCrearEditar";
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

public void prepararNuevo(ActionEvent e){
    usuario=new Usuario();
    accion=Accion.NUEVO;
}  

public void prepararEditar(ActionEvent e){
    accion=Accion.EDITAR;
}
    
public void prepararEliminar(ActionEvent e){
    accion=Accion.ELIMINAR;
}

}
