package com.wallet.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name ="wallet")
@Data
public class Wallet implements Serializable {

    private static final long serialVersionUID = 459783154987L;

    @Id
    @Column(name = "tx_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator.")
    private UUID id;
    @Column(name ="tx_name")
    @NotNull
    private String name;
    @Column(name = "nm_value")
    @NotNull
    private BigDecimal value;


}
