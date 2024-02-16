package org.iesvdm.pruebarecuud3.dao;


import org.iesvdm.pruebarecuud3.modelo.Persona;

import java.util.List;

public interface PersonaDAO {

    void create(Persona Persona);

    List<Persona> getAll();

    //Optional<Persona> find(int id);

    //void update(Persona Persona);

    //void delete(long id);

}
