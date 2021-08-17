package br.com.gerenciador.exercicio.domain.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UsuarioRequest {
    private Long id;
    @NotBlank
    private String senha;
    @NotBlank
    private String nome;
    private LocalDate dataNascimento;
    @Email
    @NotBlank
    private String email;
    private int altura;
    private double peso;
}
