package br.com.jstack.technology.framework.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestExceptionHandler {
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorResponse> handleValidationBody(MethodArgumentNotValidException ex, WebRequest request) {
//		List<String> details = ex.getBindingResult()
//			.getFieldErrors()
//			.stream()
//			.map(f -> f.getField() + ": " + f.getDefaultMessage())
//			.toList();
//
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.BAD_REQUEST.value(),
//			"Validation error on request body",
//			details,
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorResponse> handleValidationParam(ConstraintViolationException ex, WebRequest request) {
//		List<String> violations = ex.getConstraintViolations()
//			.stream()
//			.map(v -> v.getPropertyPath() + ": " + v.getMessage())
//			.toList();
//
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.BAD_REQUEST.value(),
//			"Constraint validation failed",
//			violations,
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	public ResponseEntity<ErrorResponse> handleParamMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
//		String detail = String.format("Parâmetro '%s' deve ser do tipo '%s'",
//			ex.getName(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconhecido");
//
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.BAD_REQUEST.value(),
//			"Parameter type mismatch",
//			List.of(detail),
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<ErrorResponse> handleNotFound(NoSuchElementException ex, WebRequest request) {
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.NOT_FOUND.value(),
//			"Resource not found",
//			List.of(ex.getMessage()),
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.NOT_FOUND)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.BAD_REQUEST.value(),
//			"Invalid argument",
//			List.of(ex.getMessage()),
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex, WebRequest request) {
//		log.error("Unhandled exception", ex);
//
//		ErrorResponse error = new ErrorResponse(
//			LocalDateTime.now(),
//			HttpStatus.INTERNAL_SERVER_ERROR.value(),
//			"Unexpected error",
//			List.of(ex.getMessage()),
//			getPath(request)
//		);
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//			.contentType(MediaType.APPLICATION_JSON)
//			.body(error);
//	}
//
//	private String getPath(WebRequest request) {
//		return request.getDescription(false).replace("uri=", "");
//	}
}