package com.fiap.msEnderecos.infra.controller.endereco;

import com.fiap.msEnderecos.app.usecases.endereco.ConsultarUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.ExcluirUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.RegistrarEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.ValidaUmEndereco;
import com.fiap.msEnderecos.domain.entity.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EnderecoControllerTest {

    @Mock
    private ConsultarUmEndereco consultarUmEndereco;

    @Mock
    private ExcluirUmEndereco excluirUmEndereco;

    @Mock
    private RegistrarEndereco registrarEndereco;

    @Mock
    private ValidaUmEndereco validaUmEndereco;

    @InjectMocks
    private EnderecoController enderecoController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(enderecoController).build();
    }

    @Test
    void testConsultarEndereco() throws Exception {
        Endereco endereco = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        when(consultarUmEndereco.consultarUmEndereco(1L)).thenReturn(endereco);

        mockMvc.perform(get("/endereco/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.logradouro").value("Rua A"))
                .andExpect(jsonPath("$.numero").value("123"))
                .andExpect(jsonPath("$.bairro").value("Bairro B"))
                .andExpect(jsonPath("$.cidade").value("Cidade C"))
                .andExpect(jsonPath("$.cep").value("12345-678"))
                .andExpect(jsonPath("$.latitude").value(-23.5505))
                .andExpect(jsonPath("$.longitude").value(-46.6333));
    }

    @Test
    void testExcluirEndereco() throws Exception {
        doNothing().when(excluirUmEndereco).excluirUmEndereco(1L);

        mockMvc.perform(delete("/endereco/1"))
                .andExpect(status().isOk());

        verify(excluirUmEndereco, times(1)).excluirUmEndereco(1L);
    }

    @Test
    void testCadastrarEndereco() throws Exception {
        Endereco endereco = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        when(registrarEndereco.registrarEndereco(any(Endereco.class))).thenReturn(endereco);

        mockMvc.perform(post("/endereco")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"logradouro\":\"Rua A\",\"numero\":\"123\",\"bairro\":\"Bairro B\",\"cidade\":\"Cidade C\",\"cep\":\"12345-678\",\"latitude\":-23.5505,\"longitude\":-46.6333}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.logradouro").value("Rua A"))
                .andExpect(jsonPath("$.numero").value("123"))
                .andExpect(jsonPath("$.bairro").value("Bairro B"))
                .andExpect(jsonPath("$.cidade").value("Cidade C"))
                .andExpect(jsonPath("$.cep").value("12345-678"))
                .andExpect(jsonPath("$.latitude").value(-23.5505))
                .andExpect(jsonPath("$.longitude").value(-46.6333));
    }

    @Test
    void testValidaEndereco() throws Exception {
        when(validaUmEndereco.validaEndereco(1L)).thenReturn(true);

        mockMvc.perform(get("/endereco/consultar/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}

