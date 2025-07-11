package br.ufrn.imd.clinica.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufrn.imd.clinica.domain.exception.RegraDeNegocioException;

public class Consulta {
  private final UUID id;
  private final UUID pacienteId;
  private final UUID medicoId;
  private HorarioConsulta horario;
  private StatusConsulta status;
  private String motivoCancelamento;

  // O construtor é privado para forçar o uso da Fábrica Estática (`agendar`)
  private Consulta(UUID pacienteId, UUID medicoId, HorarioConsulta horario) {
    this.id = UUID.randomUUID();
    this.pacienteId = pacienteId;
    this.medicoId = medicoId;
    this.horario = horario;
    this.status = StatusConsulta.AGENDADA; // Estado inicial sempre válido
  }

  // Método de Fábrica Estático: Garante a criação correta do agregado
  public static Consulta agendar(Paciente paciente, Medico medico, LocalDateTime dataHora) { 
    if(paciente == null)
      throw new RegraDeNegocioException("O paciente não pode ser nulo");
    if(medico == null)  
      throw new RegraDeNegocioException("O médico não pode ser nulo");
      

    final HorarioConsulta novoHorario = new HorarioConsulta(dataHora);
  
    // Aqui poderiam entrar outras regras de negócio que dependem de Paciente e Médico
    // Ex: verificar se o plano do paciente é aceito pelo médico.

    return new Consulta(paciente.getId(), medico.getId(), novoHorario);
  }  

  // --- MÉTODOS DE COMPORTAMENTO QUE PROTEGEM AS REGRAS DE NEGÓCIO (INVARIANTES)
  // ---

  public void cancelar(String motivo) {
    if (this.status != StatusConsulta.AGENDADA) {
      throw new RegraDeNegocioException("Apenas consultas agendadas podem ser canceladas.");
    }

    // Regra de negócio: não pode cancelar com menos de 24h de antecedência
    if (this.horario.getDataHora().isBefore(LocalDateTime.now().plusHours(24))) {
      throw new RegraDeNegocioException("Consulta não pode ser cancelada com menos de 24 horas de antecedência.");
    }

    this.status = StatusConsulta.CANCELADA;
    this.motivoCancelamento = motivo;
  }

  public void confirmarRealizacao() {
    if (this.status != StatusConsulta.AGENDADA) {
      throw new RegraDeNegocioException("Apenas uma consulta agendada pode ser confirmada como realizada.");
    }

    this.status = StatusConsulta.REALIZADA;
  }

  // Getters
  public UUID getId() {
    return id;
  }

  public UUID getPacienteId() {
    return pacienteId;
  }

  public UUID getMedicoId() {
    return medicoId;
  }

  public LocalDateTime getHorario() {
    return horario.getDataHora();
  }

  public StatusConsulta getStatus() {
    return status;
  }

  public String getMotivoCancelamento() {
    return motivoCancelamento;
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
    Consulta other = (Consulta) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
