package br.ufrn.imd.clinica.domain.model;

import java.util.UUID;

import br.ufrn.imd.clinica.domain.exception.AtributosInvalidosPacienteException;

public class Paciente {
  private final UUID id;
  private String nome;
  private Telefone telefone;

  public Paciente(String nome, Telefone telefone) {
    if(nome == null || nome.isBlank())
      throw new AtributosInvalidosPacienteException("O nome do paciente não pode estar vazio.");

    if(telefone == null)
      throw new AtributosInvalidosPacienteException("O telefone não pode ser nulo.");
    
    this.id = UUID.randomUUID();
    this.nome = nome;
    this.telefone = telefone;
  }

  // Getters
  public UUID getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getTelefone() {
    return this.telefone.toString();
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
    Paciente other = (Paciente) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
