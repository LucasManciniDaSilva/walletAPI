package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletItemDTOResponse {

  private UUID id;

  private UUID wallet;

  private Date date;

  private String type;

  private String description;


}
