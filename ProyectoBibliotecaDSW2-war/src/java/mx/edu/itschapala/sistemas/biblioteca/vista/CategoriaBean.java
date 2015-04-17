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
import mx.edu.itschapala.sistemas.biblioteca.bl.CategoriaBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------   
//                                                                  Llamadas a los EJB
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    @EJB
    private CategoriaBLLocal categoriaBL;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Caracteristicas
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<Categoria>lista;
    private Categoria categoria;
    private Accion accion;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                     Constructor obligatorio
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoria=new Categoria();
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                                                                 Metodos GET y SET necesarios
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Categoria> getLista(){
    lista=categoriaBL.getLista();
    return lista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Acciones
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
public String procesarPeticion(){
    switch(accion){
        case NUEVO:
            categoriaBL.registrar(categoria);
            break;
        case EDITAR:
            categoriaBL.modificar(categoria);
            break;
        case ELIMINAR:
            categoriaBL.eliminar(categoria);
            break;
    }
    accion=Accion.NADA;
    return "CategoriaListav2";
}

public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "CategoriaListav2";
    }else{
        return "CategoriaCrearEditarv2";
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                                   Eventos
//--------------------------------------------------------------------------------------------------------------------------------------------------------------   

public void prepararNuevo(ActionEvent e){
    categoria=new Categoria();
    accion=Accion.NUEVO;
}

public void prepararEditar(ActionEvent e){
    accion=Accion.EDITAR;
}

public void prepararEliminar(){
    accion=Accion.ELIMINAR;
}

}
