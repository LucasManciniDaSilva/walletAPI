package com.wallet.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
public class Users implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
}
