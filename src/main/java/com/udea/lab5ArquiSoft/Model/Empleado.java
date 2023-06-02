package com.udea.lab5ArquiSoft.Model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idperson")
    private Long idPersona;

    @Column(name="cc", nullable = false, length = 80,unique= true)
    private @NonNull Long cc;

    @Column(name="firstname", nullable = false, length = 80)
    private @NonNull String firstName;

    @Column(name="lastname", nullable = false, length = 80)
    private @NonNull String lastName;

    @Column(name="email", nullable = false, length = 80)
    private @NonNull String email;

    @Column(name="salario", nullable = false, length = 80)
    private @NonNull Integer salario;

    @Column(name="cargo", nullable = false, length = 80)
    private @NonNull String cargo;

    @Column(name="direccion", nullable = false, length = 80)
    private @NonNull String direccion;

    @Column(name="fecha_inicio", nullable = false, length = 80)
    private @NonNull Date fechaI;

    @Column(name="oficina", nullable = false, length = 80)
    private @NonNull String oficina;

    @Column(name="depenencia", nullable = false, length = 80)
    private @NonNull String dependencia;







}

