package br.com.magnasistemas.pessoas.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String estado;
    private String cidade;
    private String cep;
    private String numero;
	private String logradouro;

	public Endereco() {
		super();
	}

	public Endereco(DadosEndereco dados) {
        this.setEstado(dados.estado());
        this.setCidade(dados.cidade());
        this.setCep(dados.cep());
        this.setNumero(dados.numero());
        this.setLogradouro(dados.logradouro());
    }

    public void atualizarInformacoes(DadosEndereco dados) {
    	if (dados.estado() != null) {
            this.setEstado(dados.estado());
        }
    	if (dados.cidade() != null) {
            this.setCidade(dados.cidade());
        }
        if (dados.cep() != null) {
            this.setCep(dados.cep());
        }
        if (dados.numero() != null) {
            this.setNumero(dados.numero());
        }
        if (dados.logradouro() != null) {
            this.setLogradouro(dados.logradouro());
        }

    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}
