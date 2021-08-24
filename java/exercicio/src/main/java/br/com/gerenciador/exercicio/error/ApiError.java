package br.com.gerenciador.exercicio.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class ApiError {
    private List<Message> messages;

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Message{
        private String codigo;
        private String mensagem;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<CampoErro> campos;

        @Getter
        @Setter
        @AllArgsConstructor
        @Builder
        @ToString
        public static class CampoErro{
            private String campo;
            private String valor;
            private String mensagem;
        }

    }
}
