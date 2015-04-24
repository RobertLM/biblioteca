/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.AutorLibroDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.dao.LibroDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.AutorLibro;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Admin
 */
@Stateless
public class LibroBL implements LibroBLLocal {
    @EJB
    private AutorLibroDaoLocal autorLibroDao;
    @EJB
    private LibroDaoLocal libroDao;

    @Override
    public boolean registrar(Libro libro, List<AutorLibro> autores) {
        libroDao.crear(libro);
        for(AutorLibro autorLibro: autores){
            autorLibro.setIdLibro(libro);
            autorLibroDao.crear(autorLibro);
        }
        return false;
    }

    @Override
    public boolean eliminar(Libro libro) {
        libroDao.remover(libro);
        return false;
    }

    @Override
    public boolean modificar(Libro libro) {
        libroDao.editar(libro);
        return false;
    }

    @Override
    public List<Libro> getLista() {
        return libroDao.buscarTodos();
    }

    @Override
    public Libro getPorId(int id) {
        return libroDao.buscarPorId(id);
    }
    
    
}
