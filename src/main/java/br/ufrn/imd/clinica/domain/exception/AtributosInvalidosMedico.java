package br.ufrn.imd.clinica.domain.exception;

public class AtributosInvalidosMedico extends RegraDeNegocioException {
  public AtributosInvalidosMedico(String message) {
    super(message);
  }

  public AtributosInvalidosMedico(String message, Throwable cause) {
    super(message, cause);
  }
}
