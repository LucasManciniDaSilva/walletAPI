package com.wallet.exception;



import com.google.common.collect.Lists;
import com.wallet.exception.MessageError.ApiError;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class PreconditionFailedException extends RuntimeException {

  private static final long serialVersionUID = -5398092778833864393L;

  private final List<MessageError.ApiError> errors;

  public PreconditionFailedException(ApiError error) {
    this(Lists.newArrayList(error));
  }

  public PreconditionFailedException(List<ApiError> errors) {
    super(errors.toString());
    this.errors = errors;
  }

}
