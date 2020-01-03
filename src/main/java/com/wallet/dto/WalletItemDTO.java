package com.wallet.dto;

import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class WalletItemDTO {

  private UUID id;

  @NotNull(message = "Enter the wallet ID")
  private UUID wallet;

  @NotNull(message = "Enter a valid Date")
  private Date date;

  @NotNull(message = "Enter a valid Type")
  private String type;

  @NotNull(message = "Describe the bill that you want to pay")
  @Length(min = 5, message = "Description need at least 5 characters ")
  private String description;


}

