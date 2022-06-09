package com.alten.trial.vtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "owner id not found or missing")
public class InvalidOwnerException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InvalidOwnerException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidOwnerException(String message) {
    super(message);

  }

}
