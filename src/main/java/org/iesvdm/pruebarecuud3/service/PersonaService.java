package org.iesvdm.pruebarecuud3.service;

import org.iesvdm.pruebarecuud3.dao.PersonaDAO;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private PersonaDAO personaDAO;

    @Autowired
    public PersonaService(PersonaDAO personaDAO){
        this.personaDAO = personaDAO;
    }

    public List<Persona> listAll(){

        return personaDAO.getAll();
    }

    public void create(Persona persona) {
        personaDAO.create(persona);
    }
}

