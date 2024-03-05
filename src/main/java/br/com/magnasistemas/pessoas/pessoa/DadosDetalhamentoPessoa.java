package br.com.magnasistemas.pessoas.pessoa;

import br.com.magnasistemas.pessoas.endereco.Endereco;

public record DadosDetalhamentoPessoa(Long id, String nome, String cpf ,String formacaoacademica, String email, String telefone, String experiencia,  Endereco endereco) {

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getFormacaoacademica(), pessoa.getTelefone(), pessoa.getEmail(), pessoa.getExperiencia(), pessoa.getEndereco());
    }
}
