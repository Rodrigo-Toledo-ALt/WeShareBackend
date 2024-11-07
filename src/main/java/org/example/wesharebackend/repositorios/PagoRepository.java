package org.example.wesharebackend.repositorios;


import org.example.wesharebackend.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query("SELECT p.importe FROM Pago p WHERE p.grupo.id = :grupoId")
    List<Double> findImportesByGrupoId(@Param("grupoId") Integer grupoId);


    @Query("SELECT p.importe FROM Pago p WHERE p.grupo.id = :grupoId AND p.usuario.id = :usuarioId")
    List<Double> findImporteByGrupoIdAndUsuarioId(Integer grupoId, Integer usuarioId);

    @Query("SELECT p FROM Pago p WHERE p.grupo.id = :grupoId")
    List<Pago> findPagosByGrupoId(@Param("grupoId") Integer grupoId);
}
