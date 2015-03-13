/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesto;

/**
 *
 * @author Admin
 */
@Local
public interface PuestoDaoLocal {

    void crear(Puesto puesdo);

    void editar(Puesto puesdo);

    void remover(Puesto puesdo);

    Puesto buscarPorId(Object id);

    List<Puesto> buscarTodos();

    List<Puesto> buscarRango(int[] range);

    int contar();
    
}
