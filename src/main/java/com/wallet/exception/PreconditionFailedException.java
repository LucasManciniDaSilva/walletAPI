package com.wallet.exception;

<<<<<<< HEAD


=======
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c
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

<<<<<<< HEAD
  private final List<MessageError.ApiError> errors;
=======
  private final List<ApiError> errors;
>>>>>>> 57702a3ec372b62c56e5297ec04a33ce63f4191c

  public PreconditionFailedException(ApiError error) {
    this(Lists.newArrayList(error));
  }

  public PreconditionFailedException(List<ApiError> errors) {
    super(errors.toString());
    this.errors = errors;
  }

}
