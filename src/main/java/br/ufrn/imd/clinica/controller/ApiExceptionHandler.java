package br.ufrn.imd.clinica.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.ufrn.imd.clinica.domain.exception.AtributosInvalidosMedicoException;
import br.ufrn.imd.clinica.domain.exception.AtributosInvalidosPacienteException;
import br.ufrn.imd.clinica.domain.exception.CRMInvalidoException;
import br.ufrn.imd.clinica.domain.exception.HorarioConsultaInvalidoException;
import br.ufrn.imd.clinica.domain.exception.RegraDeNegocioException;
import br.ufrn.imd.clinica.domain.exception.TelefoneInvalidoException;
import br.ufrn.imd.clinica.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(RegraDeNegocioException.class)
  public ResponseEntity<ApiError> handleRegraDeNegocioException(RegraDeNegocioException exception, HttpServletRequest request) {
    final ApiError apiError = new ApiError(
      request.getRequestURI(),
      HttpStatus.UNPROCESSABLE_ENTITY.value(),
      exception.getLocalizedMessage(),
      OffsetDateTime.now()
    );
    
    return ResponseEntity.unprocessableEntity().body(apiError);
  }

  @ExceptionHandler(HorarioConsultaInvalidoException.class)
  public ResponseEntity<ApiError> handleHorarioConsultaInvalidoException(HorarioConsultaInvalidoException exception, HttpServletRequest request) {
    final ApiError apiError = new ApiError(
      request.getRequestURI(),
      HttpStatus.BAD_REQUEST.value(),
      exception.getLocalizedMessage(),
      OffsetDateTime.now()
    );    

    return ResponseEntity.badRequest().body(apiError);
  }

  @ExceptionHandler(TelefoneInvalidoException.class)
  public ResponseEntity<ApiError> handleTelefoneInvalidoException(TelefoneInvalidoException exception,
      HttpServletRequest request) {
    final ApiError apiError = new ApiError(
      request.getRequestURI(),
      HttpStatus.BAD_REQUEST.value(),
      exception.getLocalizedMessage(),
      OffsetDateTime.now()
    );

    return ResponseEntity.badRequest().body(apiError);
  } 
  
  @ExceptionHandler(AtributosInvalidosPacienteException.class)
  public ResponseEntity<ApiError> handleAtributosInvalidosPacienteException(AtributosInvalidosPacienteException exception,
      HttpServletRequest request) {
    final ApiError apiError = new ApiError(
        request.getRequestURI(),
        HttpStatus.BAD_REQUEST.value(),
        exception.getLocalizedMessage(),
        OffsetDateTime.now());

    return ResponseEntity.badRequest().body(apiError);
  }  

  @ExceptionHandler(AtributosInvalidosMedicoException.class)
  public ResponseEntity<ApiError> handleAtributosInvalidosMedicoException(
      AtributosInvalidosMedicoException exception,
      HttpServletRequest request) {
    final ApiError apiError = new ApiError(
        request.getRequestURI(),
        HttpStatus.BAD_REQUEST.value(),
        exception.getLocalizedMessage(),
        OffsetDateTime.now());

    return ResponseEntity.badRequest().body(apiError);
  }  

  @ExceptionHandler(CRMInvalidoException.class)
  public ResponseEntity<ApiError> handleCRMInvalidoException(
      CRMInvalidoException exception,
      HttpServletRequest request) {
    final ApiError apiError = new ApiError(
        request.getRequestURI(),
        HttpStatus.BAD_REQUEST.value(),
        exception.getLocalizedMessage(),
        OffsetDateTime.now());

    return ResponseEntity.badRequest().body(apiError);
  }  


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleGenericException(Exception exception, HttpServletRequest request) {
    final ApiError apiError = new ApiError(
      request.getRequestURI(),
      HttpStatus.INTERNAL_SERVER_ERROR.value(),
      exception.getLocalizedMessage(),
      OffsetDateTime.now()
    );

    return ResponseEntity.internalServerError().body(apiError);
  }

}
