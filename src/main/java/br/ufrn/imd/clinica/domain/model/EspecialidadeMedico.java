package br.ufrn.imd.clinica.domain.model;

public enum EspecialidadeMedico {
  CARDIOLOGIA("CARDIOLOGIA"),
  DERMATOLOGIA("DERMATOLOGIA"),
  ORTOPEDIA("ORTOPEDIA"),
  PEDIATRIA("PEDIATRIA"),
  GINECOLOGIA("GINECOLOGIA");

  private String especialidade;

  EspecialidadeMedico(String especialidade) {
    this.especialidade = especialidade.toUpperCase();
  }

  public String getEspecialidade() {
    return this.especialidade.toUpperCase();
  }
}


