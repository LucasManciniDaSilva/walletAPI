package com.wallet.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name ="users_wallet")
@Data
public class UserWallet implements Serializable {

    private static final long serialVersionUID = 459783154982L;

    @Id
    @Column(name = "tx_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator.")
    private UUID id;
    @JoinColumn(name = "tx_users", referencedColumnName = "tx_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;
    @JoinColumn(name = "tx_wallet", referencedColumnName = "tx_id")
    private Wallet wallet;


}
