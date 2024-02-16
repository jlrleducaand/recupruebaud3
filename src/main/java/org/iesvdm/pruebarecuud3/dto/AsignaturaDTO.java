package org.iesvdm.pruebarecuud3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor

public class AsignaturaDTO {

    private int id;
    private String nombre;
    private String creditos;
    private String tipo;
    private int curso;
    private int cuatrimestre;
    private int id_profesor;
}