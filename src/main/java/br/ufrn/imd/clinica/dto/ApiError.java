package br.ufrn.imd.clinica.dto;

import java.time.OffsetDateTime;

public record ApiError(
  String requestPath,
  int statusCode,
  String errorMessage,
  OffsetDateTime timestamp  
) {}
