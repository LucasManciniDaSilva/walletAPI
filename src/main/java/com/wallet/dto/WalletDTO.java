package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDTO {

    private UUID id;
    @Length(min = 3)
    @NotNull
    private String name;
    @NotNull
    private BigDecimal value;

}
