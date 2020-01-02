package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWalletDTO {

  private UUID id;
  @NotNull(message = "Enter the user ID")
  private UUID users;
  @NotNull(message = "Enter the wallet ID")
  private UUID wallet;


}
