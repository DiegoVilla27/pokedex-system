package com.dv.pokedex.core.exceptions.handlers;

import com.dv.pokedex.core.exceptions.dto.ErrorResponseDTO;
import com.dv.pokedex.core.exceptions.exceptions.ApiException;
import com.dv.pokedex.core.exceptions.factories.ErrorResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final ErrorResponseFactory errorResponseFactory;

    /**
     * Handles domain and application-specific exceptions derived from {@link ApiException}.
     *
     * @param e custom business exception thrown by the application.
     * @return a structured {@link ErrorResponseDTO} wrapped in a {@link ResponseEntity}.
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponseDTO> handle(ApiException e) {
        return errorResponseFactory.build(e.getHttpStatus(), e.getMessage(), List.of());
    }
}
