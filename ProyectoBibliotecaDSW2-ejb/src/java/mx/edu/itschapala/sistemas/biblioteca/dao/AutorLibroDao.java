/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.edu.itschapala.sistemas.biblioteca.modelo.AutorLibro;

/**
 *
 * @author Admin
 */
@Stateless
public class AutorLibroDao extends AbstractDao<AutorLibro> implements AutorLibroDaoLocal {
    @PersistenceContext(unitName = "ProyectoBibliotecaDSW2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorLibroDao() {
        super(AutorLibro.class);
    }
    
}
