package br.com.magnasistemas.pessoas.pessoa;

import br.com.magnasistemas.pessoas.endereco.Endereco;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "pessoas")
@Entity(name = "Pessoa")

@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String formacaoacademica;
    private String telefone;
    private String email;
    private String experiencia;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
    
    public Pessoa() {
		super();
	}

    public Pessoa(DadosCadastroPessoa dados) {
        this.setAtivo(true);
        this.setNome(dados.nome());
        this.setCpf(dados.cpf());
        this.setFormacaoacademica(dados.formacaoacademica());
        this.setTelefone(dados.telefone());
        this.setEmail(dados.email());
        this.setExperiencia(dados.experiencia());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) {
            this.setNome(dados.nome());
        }
        if (dados.telefone() != null) {
            this.setTelefone(dados.telefone());
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.setAtivo(false);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFormacaoacademica() {
		return formacaoacademica;
	}

	public void setFormacaoacademica(String formacaoacademica) {
		this.formacaoacademica = formacaoacademica;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Endereco getEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

}
