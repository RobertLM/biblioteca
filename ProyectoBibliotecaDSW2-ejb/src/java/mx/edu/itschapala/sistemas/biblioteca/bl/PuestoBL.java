/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.PuestoDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesdo;

/**
 *
 * @author Admin
 */
@Stateless
public class PuestoBL implements PuestoBLLocal {
    @EJB
    private PuestoDaoLocal puestoDao;

    @Override
    public boolean registrar(Puesdo puesto) {
        puestoDao.crear(puesto);
        return false;
    }

    @Override
    public boolean eliminar(Puesdo puesto) {
        puestoDao.remover(puesto);
        return false;
    }

    @Override
    public boolean modificar(Puesdo puesto) {
        puestoDao.editar(puesto);
        return false;
    }

    @Override
    public List<Puesdo> getLista() {
        return puestoDao.buscarTodos();
    }

    @Override
    public Puesdo getPorId(int id) {
        return puestoDao.buscarPorId(id);
    }
    
}
