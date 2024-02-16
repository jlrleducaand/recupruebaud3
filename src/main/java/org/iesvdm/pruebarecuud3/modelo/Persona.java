package org.iesvdm.pruebarecuud3.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {



	private int id;
	private String nif;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private String direccion;
	private String telefono;
	private Date fecha_nacimiento;
	private String tipo;


}
