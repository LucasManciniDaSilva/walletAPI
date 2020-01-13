package com.wallet.exception;

import com.google.common.collect.Lists;
import com.wallet.exception.MessageError;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class UnprocessableEntityException extends RuntimeException {

  private static final long serialVersionUID = -5012441619995884439L;

  private final List<MessageError.ApiError> errors;

  public UnprocessableEntityException(MessageError.ApiError error) {
    this(Lists.newArrayList(error));
  }

  public UnprocessableEntityException(List<MessageError.ApiError> errors) {
    super(errors.toString());
    this.errors = errors;
  }

  public UnprocessableEntityException(MessageError.ApiError error, String detail) {
    super(String.format("%s - Detail: %s", error.toString(), detail));
    this.errors = Lists.newArrayList(error);
  }

  public UnprocessableEntityException(MessageError.ApiError error, String detail, Throwable ex) {
    super(String.format("%s - Detail: %s", error.toString(), detail), ex);
    this.errors = Lists.newArrayList(error);
  }
}
