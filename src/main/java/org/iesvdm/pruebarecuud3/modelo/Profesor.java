package org.iesvdm.pruebarecuud3.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    private int id_profesor;
    private int id_departamento;
}
