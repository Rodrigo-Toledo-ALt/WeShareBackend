package org.example.wesharebackend.repositorios;

import org.example.wesharebackend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

}
