package br.com.magnasistemas.pessoas.pessoa;

import br.com.magnasistemas.pessoas.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
