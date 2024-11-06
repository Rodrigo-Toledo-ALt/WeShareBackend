package org.example.wesharebackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wesharebackend.modelos.Grupo;
import org.example.wesharebackend.modelos.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {

    private Integer id;
    private Double importe;
    private String descripcion;
    private String fecha;
    private Usuario usuario;
    private Grupo grupo;

}
