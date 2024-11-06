package org.example.wesharebackend.servicios;


import lombok.AllArgsConstructor;
import org.example.wesharebackend.DTO.PagoDTO;
import org.example.wesharebackend.modelos.Pago;
import org.example.wesharebackend.repositorios.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public PagoDTO añadirPago(PagoDTO pagoDTO) {

        Pago pago = new Pago();
        pago.setImporte(pagoDTO.getImporte());
        pago.setDescripcion(pagoDTO.getDescripcion());
        pago.setFecha(pagoDTO.getFecha());
        pago.setGrupo(pagoDTO.getGrupo());
        pago.setUsuario(pagoDTO.getUsuario());

        pagoRepository.save(pago);

        return pagoDTO;
    }
}
