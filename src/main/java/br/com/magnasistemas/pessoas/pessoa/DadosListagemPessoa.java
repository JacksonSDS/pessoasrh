package br.com.magnasistemas.pessoas.pessoa;

public record DadosListagemPessoa(Long id, String nome, String cpf, String formacaoacademica, String telefone, String email, String experiencia) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getFormacaoacademica(), pessoa.getTelefone(), pessoa.getEmail(),
        		pessoa.getExperiencia());
    }

}
