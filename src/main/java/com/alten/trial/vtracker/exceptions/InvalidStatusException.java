package com.alten.trial.vtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "invalid status was provided")
public class InvalidStatusException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InvalidStatusException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidStatusException(String message) {
    super(message);

  }

}
