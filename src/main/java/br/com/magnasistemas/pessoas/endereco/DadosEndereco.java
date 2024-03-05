package br.com.magnasistemas.pessoas.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        
        @NotBlank
        String estado,
        @NotBlank
        String cidade,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String numero,
        @NotBlank
        String logradouro) {
}
