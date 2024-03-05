package br.com.magnasistemas.pessoas.domain;

@SuppressWarnings("serial")
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
