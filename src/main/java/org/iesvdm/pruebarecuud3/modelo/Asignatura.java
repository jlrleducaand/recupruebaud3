package org.iesvdm.pruebarecuud3.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans

@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor

public class Asignatura {
	
	private int id;
	private String nombre;
	private String creditos;
	private String tipo;
	private int curso;
	private int cuatrimestre;
	private int id_profesor;

}
