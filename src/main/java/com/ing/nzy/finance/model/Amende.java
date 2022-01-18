package com.ing.nzy.finance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID infractionId;

    private String personCin;

    private UUID personId;

    private Double montant;

    private Boolean payee = false;

    @CreationTimestamp
    private Timestamp dateCreation;

    @Version
    private Integer version;

    private LocalDate dateEcheance;

}
