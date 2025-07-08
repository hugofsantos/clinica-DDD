package br.ufrn.imd.clinica.domain.exception;

public class TelefoneInvalidoException extends RegraDeNegocioException{
  public TelefoneInvalidoException(String message) {
    super(message);
  }

  public TelefoneInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }
}
