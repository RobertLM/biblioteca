/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesdo;

/**
 *
 * @author Admin
 */
@Local
public interface PuestoDaoLocal {

    void crear(Puesdo puesdo);

    void editar(Puesdo puesdo);

    void remover(Puesdo puesdo);

    Puesdo buscarPorId(Object id);

    List<Puesdo> buscarTodos();

    List<Puesdo> buscarRango(int[] range);

    int contar();
    
}
