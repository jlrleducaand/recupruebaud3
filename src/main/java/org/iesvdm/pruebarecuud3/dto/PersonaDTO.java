package org.iesvdm.pruebarecuud3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {



    private int id;
    @NotNull
    @NotBlank
    @Size(max = 9, message = )
    private String nif;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private String direccion;
    private String telefono;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fecha_nacimiento;
    private String tipo;


}