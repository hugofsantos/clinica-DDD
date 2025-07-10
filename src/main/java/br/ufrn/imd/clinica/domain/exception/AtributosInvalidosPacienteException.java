package br.ufrn.imd.clinica.domain.exception;

public class AtributosInvalidosPacienteException extends RegraDeNegocioException{
  public AtributosInvalidosPacienteException(String message) {
    super(message);
  }

  public AtributosInvalidosPacienteException(String message, Throwable cause) {
    super(message, cause);
  }
}
