package org.example.wesharebackend.controladores;

import lombok.AllArgsConstructor;
import org.example.wesharebackend.DTO.PagoDTO;
import org.example.wesharebackend.servicios.PagoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pago")
@AllArgsConstructor
public class PagoController {

    private PagoService PagoService;

    @PostMapping("/añadir")
    private PagoDTO añadirPago(@RequestBody PagoDTO pagoDTO){

        return PagoService.añadirPago(pagoDTO);
    }

}
