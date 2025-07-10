package br.ufrn.imd.clinica.domain.model;

import br.ufrn.imd.clinica.domain.exception.TelefoneInvalidoException;

public final class Telefone {
  // private final static Pattern APENAS_DIGITOS = Pattern.compile("\\d+");

  private final String ddd;
  private final String numero;
  
  public Telefone(String ddd, String numero) {
    String dddLimpo = sanitizar(ddd);
    String numeroLimpo = sanitizar(numero);

    this.validar(dddLimpo, numeroLimpo);

    this.ddd = dddLimpo;
    this.numero = numeroLimpo;
  }

  private void validar(String ddd, String numero) {
    if(ddd == null)
      throw new TelefoneInvalidoException("O DDD não pode ser nulo.");
    
    if(numero == null)
      throw new TelefoneInvalidoException("O número do telefone não pode ser nulo.");

    if (ddd.isBlank() || numero.isBlank()) {
        throw new TelefoneInvalidoException("DDD e número são obrigatórios.");
    }
    if (ddd.length() != 2) {
        throw new TelefoneInvalidoException("O DDD deve ter exatamente 2 dígitos.");
    }
    if (numero.length() < 8 || numero.length() > 9) {
        throw new TelefoneInvalidoException("O número deve ter 8 ou 9 dígitos.");
    }
  }

  private String sanitizar(String valor) {
    return (valor == null) ? "" : valor.replaceAll("[^\\d]", "");
  }

  // --- Comportamentos (além de simples getters) ---
  public String getNumeroCompletoFormatado() {
    if (numero.length() == 9) {
      return String.format("(%s) %s-%s", ddd, numero.substring(0, 5), numero.substring(5));
    } else { // 8 dígitos
      return String.format("(%s) %s-%s", ddd, numero.substring(0, 4), numero.substring(4));
    }
  }

  // --- Getters e Métodos de Igualdade ---
  public String getDdd() {
    return ddd;
  }

  public String getNumero() {
    return numero;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
    Telefone other = (Telefone) obj;
    if (ddd == null) {
      if (other.ddd != null)
        return false;
    } else if (!ddd.equals(other.ddd))
      return false;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    return true;
  }
}
