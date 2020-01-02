package com.wallet.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Data
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "tx_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator.")
    private UUID id;
    @Column(name = "tx_password", nullable = false)
    private String password;
    @Column(name = "tx_name", nullable = false)
    private String name;
    @Column(name = "tx_email", nullable = false)
    private String email;
}
