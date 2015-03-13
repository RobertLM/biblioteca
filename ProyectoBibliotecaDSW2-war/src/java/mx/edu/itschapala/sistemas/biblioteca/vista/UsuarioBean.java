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
import mx.edu.itschapala.sistemas.biblioteca.bl.UsuarioBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Usuario;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    @EJB
    private UsuarioBLLocal usuarioBL;

    private List<Usuario>lista;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public List<Usuario>getLista(){
    lista=usuarioBL.getLista();
    return lista;
    }
}
