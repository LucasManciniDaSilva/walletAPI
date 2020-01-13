package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWalletDTOResponse {

  private UUID id;

  private UUID users;

  private UUID wallet;


}
