package org.example.wesharebackend.servicios;


import lombok.AllArgsConstructor;
import org.example.wesharebackend.DTO.GrupoDTO;
import org.example.wesharebackend.DTO.UsuarioDTO;
import org.example.wesharebackend.modelos.Grupo;
import org.example.wesharebackend.modelos.Usuario;
import org.example.wesharebackend.repositorios.GrupoRepository;
import org.example.wesharebackend.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    private UsuarioRepository usuarioRepository;

    public GrupoDTO crearGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setNombre(grupoDTO.getNombre());
        grupo.setNumIntegrantes(grupoDTO.getNumIntegrantes());
        grupo.setFechaCreacion(grupoDTO.getFechaCreacion());

        grupoRepository.save(grupo);

        return grupoDTO;
    }

    public List<UsuarioDTO> añadirParticipante(Integer id_usuario,Integer id_grupo){
        Usuario usuario = usuarioRepository.findById(id_usuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Grupo grupo = grupoRepository.findById(id_grupo).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        usuario.getGrupos().add(grupo);
        usuarioRepository.save(usuario);

        List<Usuario> Usuarios = usuarioRepository.findUsuariosByGrupoId(id_grupo);
        List<UsuarioDTO> UsuariosDTO = new ArrayList<>();

        for (Usuario u: Usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(u.getId());
            usuarioDTO.setNombre(u.getNombre());
            usuarioDTO.setCorreo(u.getCorreo());
            usuarioDTO.setContraseña(u.getContraseña());
            UsuariosDTO.add(usuarioDTO);
        }

        return UsuariosDTO;
     }

    public List<UsuarioDTO> verParticipantesGrupo(Integer id_grupo){
        List<Usuario> Usuarios = usuarioRepository.findUsuariosByGrupoId(id_grupo);
        List<UsuarioDTO> UsuariosDTO = new ArrayList<>();

        for (Usuario u: Usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(u.getId());
            usuarioDTO.setNombre(u.getNombre());
            usuarioDTO.setCorreo(u.getCorreo());
            usuarioDTO.setContraseña(u.getContraseña());
            UsuariosDTO.add(usuarioDTO);
        }

        return UsuariosDTO;
    }

    public List<UsuarioDTO> eliminarParticipantesGrupo(Integer id_usuario, Integer id_grupo){
        Usuario usuario = usuarioRepository.findById(id_usuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Grupo grupo = grupoRepository.findById(id_grupo).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        usuario.getGrupos().remove(grupo);
        usuarioRepository.save(usuario);

        List<Usuario> Usuarios = usuarioRepository.findUsuariosByGrupoId(id_grupo);
        List<UsuarioDTO> UsuariosDTO = new ArrayList<>();

        for (Usuario u: Usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(u.getId());
            usuarioDTO.setNombre(u.getNombre());
            usuarioDTO.setCorreo(u.getCorreo());
            usuarioDTO.setContraseña(u.getContraseña());
            UsuariosDTO.add(usuarioDTO);
        }

        return UsuariosDTO;
    }


}
