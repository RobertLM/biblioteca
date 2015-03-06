/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesdo;

/**
 *
 * @author Admin
 */
@Local
public interface PuestoBLLocal {

    boolean registrar(Puesdo puesto);

    boolean eliminar(Puesdo puesto);

    boolean modificar(Puesdo puesto);

    List<Puesdo> getLista();

    Puesdo getPorId(int id);
    
}
