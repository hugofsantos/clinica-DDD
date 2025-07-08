package br.ufrn.imd.clinica.domain.model;

public enum StatusConsulta {
  AGENDADA("AGENDADA"),
  REALIZADA("REALIZADA"),
  CANCELADA("CANCELADA");

  private String status;

  StatusConsulta(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }
}
