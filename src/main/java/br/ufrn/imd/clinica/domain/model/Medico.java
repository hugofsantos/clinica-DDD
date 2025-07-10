package br.ufrn.imd.clinica.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import br.ufrn.imd.clinica.domain.exception.AtributosInvalidosMedico;

public class Medico {
  private final UUID id;
  private String nome;
  private final CRM crm;
  private final Set<EspecialidadeMedico> especialidades;
  private boolean ativo;
  
  public Medico(String nome, CRM crm, Set<EspecialidadeMedico> especialidadesIniciais) {
    if(nome == null || nome.isBlank())
      throw new AtributosInvalidosMedico("O nome do médico não pode estar vazio.");

    if(crm == null)
      throw new AtributosInvalidosMedico("O CRM do médico não pode estar vazio");

    this.id = UUID.randomUUID();
    this.nome = nome;
    this.crm = crm;
    this.especialidades = new HashSet<>(especialidadesIniciais == null ? Collections.emptySet() : especialidadesIniciais);
    this.ativo = true;
  }

  // Comportamentos
  public void adicionarEspecialidade(EspecialidadeMedico especialidadeMedico) {
    this.especialidades.add(especialidadeMedico);
  }

  public void inativar() {
    this.ativo = false;
  }

  // Getters
  public UUID getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCRM() {
    return this.crm.toString();
  }

  public Set<EspecialidadeMedico> getEspecialidades() {
    return Collections.unmodifiableSet(this.especialidades);
  }

  public boolean isAtivo() {
    return this.ativo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    Medico other = (Medico) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
