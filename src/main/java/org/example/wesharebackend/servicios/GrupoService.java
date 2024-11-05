package org.example.wesharebackend.servicios;


import lombok.AllArgsConstructor;
import org.example.wesharebackend.DTO.GrupoDTO;
import org.example.wesharebackend.modelos.Grupo;
import org.example.wesharebackend.repositorios.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoDTO crearGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setNombre(grupoDTO.getNombre());
        grupo.setNumIntegrantes(grupoDTO.getNumIntegrantes());
        grupo.setFechaCreacion(grupoDTO.getFechaCreacion());

        grupoRepository.save(grupo);
        return grupoDTO;
    }






}
