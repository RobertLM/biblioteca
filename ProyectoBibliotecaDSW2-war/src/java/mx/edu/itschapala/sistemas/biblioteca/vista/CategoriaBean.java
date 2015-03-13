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
import mx.edu.itschapala.sistemas.biblioteca.bl.CategoriaBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {
    
    @EJB
    private CategoriaBLLocal categoriaBL;

    private List<Categoria>lista;
    
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }
    
    public List<Categoria> getLista(){
    lista=categoriaBL.getLista();
    return lista;
    }
    
}
