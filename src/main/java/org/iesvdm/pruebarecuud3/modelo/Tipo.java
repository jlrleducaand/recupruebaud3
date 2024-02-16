package org.iesvdm.pruebarecuud3.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Tipo {
    List<String> tipos = new ArrayList<>(Arrays.asList("catedratico", "Profesor", "Alumno"));



}
