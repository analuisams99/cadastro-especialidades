package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

/**Classe ApplicationError.*/
public class ApplicationError {
  private Status status;
  private String message;
  
  public ApplicationError(Status status, String message) {
    this.status = status;
    this.message = message;
  }
  
  public Status getStatus() {
    return status;
  }
  
  public String getMessage() {
    return message;
  }
}