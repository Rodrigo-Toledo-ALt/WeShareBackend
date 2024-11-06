package org.example.wesharebackend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "pago", schema = "weshare", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "importe", nullable = false)
    private Double importe;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column (name = "fecha_gasto", nullable = false)
    private String fecha;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;


}
