package br.ufrn.imd.clinica.domain.model;

public final class CRM {
  private final String numero;
  private final String uf;

  public CRM(String numero, String uf) {
    // Validações (simplificadas para o exemplo)
    if (numero == null || numero.isBlank() || uf == null || uf.isBlank()) {
      throw new IllegalArgumentException("Número e UF do CRM são obrigatórios.");
    }
    if (uf.length() != 2) {
      throw new IllegalArgumentException("UF do CRM deve ter 2 caracteres.");
    }
    this.numero = numero;
    this.uf = uf.toUpperCase();
  }

  public String getFormatado() {
    return String.format("%s/%s", numero, uf);
  }

  // Getters, equals, hashCode e toString
  public String getNumero() {
    return numero;
  }

  public String getUf() {
    return uf;
  }

  @Override
  public String toString() {
    return this.getFormatado();
  }
}
