package com.alten.trial.vtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a queried resource was not found.
 * 
 * @author AbdelghafarAhmed
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "owner not found")
public class ResourceNotFoundException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String message, Throwable cause) {
    super(message, cause);

  }

  public ResourceNotFoundException(String message) {
    super(message);

  }

}
