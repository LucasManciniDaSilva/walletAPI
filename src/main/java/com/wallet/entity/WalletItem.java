package com.wallet.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet_items")
public class WalletItem implements Serializable {

  private static final long serialVersionUID = 5798745684231L;

  @Id
  @Column(name = "tx_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator.")
  private UUID id;

  @JoinColumn(name = "tx_wallet", referencedColumnName = "tx_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Wallet wallet;

  @NotNull
  @Column(name = "dt_date")
  private Date date;

  @NotNull
  @Column(name = "tx_type")
  private String type;

  @NotNull
  @Column(name = "tx_description")
  private String description;

  @NotNull
  @Column(name = "nm_value")
  private BigDecimal value;
}
