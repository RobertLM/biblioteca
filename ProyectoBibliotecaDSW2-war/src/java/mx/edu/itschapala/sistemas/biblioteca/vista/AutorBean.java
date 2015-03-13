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
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class AutorBean {
    //Llamadas a los EJB
    @EJB
    private AutorBLLocal autorBL;

    //Caracteristicas
    private List<Autor>lista;
    
    //Constructor obligatorio
    public AutorBean() {
    }
    
    
    //Metodos GET y SET necesarios
    
    public List<Autor> getLista(){
        lista=autorBL.getLista();
        return lista;
    }
    
}
