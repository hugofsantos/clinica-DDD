package br.ufrn.imd.clinica.domain.model;

import java.time.LocalDateTime;

import br.ufrn.imd.clinica.domain.exception.HorarioConsultaInvalidoException;

public final class HorarioConsulta {
  private final LocalDateTime dataHora;

  public HorarioConsulta(LocalDateTime dataHora) {
    if(dataHora == null)
      throw new HorarioConsultaInvalidoException("A data e hora não podem ser nulas");

    if(dataHora.isBefore(LocalDateTime.now()))
      throw new HorarioConsultaInvalidoException("Não é possível criar um horário de consulta no passado");
    
    this.dataHora = dataHora;
  }

  public LocalDateTime getDataHora() {
    return this.dataHora;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HorarioConsulta other = (HorarioConsulta) obj;
    if (dataHora == null) {
      if (other.dataHora != null)
        return false;
    } else if (!dataHora.equals(other.dataHora))
      return false;
    return true;
  }
}
