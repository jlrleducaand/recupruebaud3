package org.iesvdm.pruebarecuud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j
//Un Repository es un componente y a su vez un estereotipo de Spring para el CRUD
//que forma parte de la ‘capa de persistencia con  Acceso a BBDD’.
@Repository
public class PersonaDAOImpl implements PersonaDAO{

    //Plantilla jdbc inyectada automáticamente por el framework Spring, gracias a la anotación @Autowired.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Persona> getAll() {

        List<Persona> listPersona = jdbcTemplate.query(
                "SELECT * FROM Persona",
                (rs, rowNum) -> new Persona(
                        rs.getInt("id"),
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("ciudad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("tipo")
                )
        );

        log.info("Devueltos {} registros.", listPersona.size());

        return listPersona;

    }

    @Override
    public synchronized void create(Persona persona) {

        String sqlInsert = """
				INSERT INTO persona
					(nif,nombre,apellido2,apellido2,ciudad,
					direccion,telefono,fecha_nacimiento,tipo
					)
					VALUES
					(	?,	?, ?, ?, ?,	?, ?, DATE (?),?);
				""";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id_persona" });
            int idx = 1;
            ps.setString(idx++, persona.getNif());
            ps.setString(idx++, persona.getNombre());
            ps.setString(idx++, (persona.getApellido1()));
            ps.setString(idx++, persona.getCiudad());
            ps.setString(idx++, persona.getDireccion());
            ps.setString(idx++, persona.getTelefono());
            //Conversión de java.util.Date a java.sqlDate
            ps.setDate(idx++, new java.sql.Date (persona.getFecha_nacimiento().getTime()));
            ps.setString(idx++, persona.getTipo());

            return ps;
        }, keyHolder);

        persona.setId(keyHolder.getKey().intValue());

		/*
		Sin recuperación de id generado
		int rows = jdbcTemplate.update(sqlInsert,
							cliente.getNombre(),
							cliente.getApellido1(),
							cliente.getApellido2(),
							cliente.getCiudad(),
							cliente.getCategoria()
					);
					*/

        log.info("Insertados {} registros.", rows);
    }




}
