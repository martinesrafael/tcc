package br.com.gerenciador.exercicio.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(Object obj){
        super("Erro ao encontrar usuario: " + obj);
    }
}
