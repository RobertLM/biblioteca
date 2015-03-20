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
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class LibroBean {
    @EJB
    private LibroBLLocal libroBL;

    private List<Libro>lista;
    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {
    }
    
    public List<Libro>getLista(){
    lista=libroBL.getLista();
    return lista;
    }
}