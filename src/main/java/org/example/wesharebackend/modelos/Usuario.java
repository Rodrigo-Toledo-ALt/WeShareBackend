package org.example.wesharebackend.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario", schema = "WeShare", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @OneToMany(targetEntity = Pago.class, mappedBy = "usuario")
    private Set<Pago> pagos;


    //relación tabla usuario_grupo
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Grupo.class)
    @JoinTable(name = "usuario_grupo", schema = "WeShare", catalog = "postgres",
            joinColumns = {@JoinColumn(name = "id_usuario", nullable = false)} ,
            inverseJoinColumns ={@JoinColumn(name = "id_grupo", nullable = false)})
    private Set<Grupo> grupos = new HashSet<>(0);





}