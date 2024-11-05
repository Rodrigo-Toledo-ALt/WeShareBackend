package org.example.wesharebackend.controladores;


import lombok.AllArgsConstructor;
import org.example.wesharebackend.DTO.GrupoDTO;
import org.example.wesharebackend.modelos.Grupo;
import org.example.wesharebackend.servicios.GrupoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
@AllArgsConstructor
public class GrupoController {

private GrupoService grupoService;

    @PostMapping("/crear")
    private GrupoDTO crearGrupo(@RequestBody GrupoDTO grupoDTO){ return grupoService.crearGrupo(grupoDTO);}



}
