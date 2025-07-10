package br.ufrn.imd.clinica.domain.exception;

public class CRMInvalidoException extends RegraDeNegocioException{
  public CRMInvalidoException(String message) {
    super(message);
  }
  public CRMInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }
}
