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
    @NotBlank(message = "Senha não pode ser nula ou em branco")
    private String senha;
    @NotBlank(message = "Nome não pode ser nula ou em branco")
    private String nome;
    private LocalDate dataNascimento;
    @Email(message = "O e-mail deve ser valido")
    @NotBlank(message = "E-mail não pode ser nula ou em branco")
    private String email;
    private int altura;
    private double peso;
}
