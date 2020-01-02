package com.wallet.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "users_wallet")
public class UserWallet implements Serializable {

  private static final long serialVersionUID = 579872654231L;

  @Id
  @Column(name = "tx_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator.")
  private UUID id;

  @JoinColumn(name = "tx_users", referencedColumnName = "tx_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Users users;

  @JoinColumn(name = "tx_wallet", referencedColumnName = "tx_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Wallet wallet;
}
