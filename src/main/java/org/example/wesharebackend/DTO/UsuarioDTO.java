package org.example.wesharebackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private String contraseña;
}
