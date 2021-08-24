package br.com.gerenciador.exercicio.handler;

import br.com.gerenciador.exercicio.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestUserExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ApiError badResquestHandler(BindException request) {
        List<ApiError.Message.CampoErro> campos = request.getBindingResult().getAllErrors()
                .stream().map(erro -> ApiError.Message.CampoErro.builder()
                        .campo(((FieldError) erro).getField())
                        .mensagem(erro.getDefaultMessage())
                        .valor(String.valueOf(((FieldError) erro).getRejectedValue()))
                        .build())
                .collect(Collectors.toList());

        return ApiError.builder()
                .messages(List.of(
                        ApiError.Message.builder()
                                .mensagem("Parametros Invalidos")
                                .codigo(HttpStatus.BAD_REQUEST.toString())
                                .campos(campos)
                                .build()
                ))
                .build();
    }
}

