package org.example.wesharebackend.repositorios;


import org.example.wesharebackend.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
