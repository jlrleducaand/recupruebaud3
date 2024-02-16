package org.iesvdm.pruebarecuud3.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDTO {


    private int id_profesor;
    private int id_departamento;
}
