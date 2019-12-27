package com.wallet.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wallet.logger.PCIClassicConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageError {

  private MessageSource messageSource;

  public MessageError(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public ApiError create(String code) {
    return new ApiError(
        code, messageSource.getMessage(code, null, LocaleContextHolder.getLocale()));
  }

  public ApiError create(String code, String description) {
    return new ApiError(code, description);
  }

  public ApiError create(String code, Object[] interpolateWith) {
    return new ApiError(
        code, messageSource.getMessage(code, interpolateWith, LocaleContextHolder.getLocale()));
  }

  @Data
  @EqualsAndHashCode
  @ToString
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static final class ApiError {

    private String code;
    private String description;

    private ApiError(String code, String description) {
      this.code = code;
      this.description = description;
    }

    public String getDescription() {
      return PCIClassicConverter.formatMessage(description);
    }
  }
}
