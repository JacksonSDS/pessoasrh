package br.com.magnasistemas.pessoas.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.magnasistemas.pessoas.endereco.DadosEndereco;
import br.com.magnasistemas.pessoas.endereco.Endereco;
import br.com.magnasistemas.pessoas.pessoa.DadosCadastroPessoa;
import br.com.magnasistemas.pessoas.pessoa.DadosDetalhamentoPessoa;
import br.com.magnasistemas.pessoas.pessoa.Pessoa;
import br.com.magnasistemas.pessoas.pessoa.PessoaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroPessoa> dadosCadastroMedicoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoPessoa> dadosDetalhamentoMedicoJson;

    @MockBean
    private PessoaRepository repository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/pessoas"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    void cadastrar_cenario2() throws Exception {
        var dadosCadastro = new DadosCadastroPessoa(
                "Pessoa",
                "12345678905",
                "Ensino medio",
                "61999999999",
                "Jackson@gmail.com",
                "Sim",
                dadosEndereco());

        when(repository.save(any())).thenReturn(new Pessoa(dadosCadastro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoPessoa(
                null,
                dadosCadastro.nome(),
                dadosCadastro.cpf(),
                dadosCadastro.formacaoacademica(),
                dadosCadastro.telefone(),
                dadosCadastro.email(),
                dadosCadastro.experiencia(),
                new Endereco(dadosCadastro.endereco())
        );
        var jsonEsperado = dadosDetalhamentoMedicoJson.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "Sao Paulo",
                "Santo Amaro",
                "00000000",
                "35",
                "Rua avenida"
        );
    }

}
