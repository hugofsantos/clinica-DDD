package br.ufrn.imd.clinica.domain.exception;

public class HorarioConsultaInvalidoException extends BusinessException {
  public HorarioConsultaInvalidoException(String message) {
    super(message);
  }

  public HorarioConsultaInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }
}
