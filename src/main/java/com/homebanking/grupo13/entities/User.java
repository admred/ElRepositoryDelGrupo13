package com.homebanking.grupo13.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario")
    private String username;

    @Column(name = "contrasenia")
    private String password;

    private String email;

    private String dni;

    @Column(name = "direccion")
    private String address;

    @Column(name = "fecha_cumpleanios")
    private Date birthday_date;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    // Fecha de creación y modificación (estado) de cada usuarios
    // TODO: Refactor
    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}
