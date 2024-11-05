package org.example.wesharebackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GrupoDTO {
    private Integer id;
    private String nombre;
    private Integer numIntegrantes;
    private LocalDate fechaCreacion;
}
