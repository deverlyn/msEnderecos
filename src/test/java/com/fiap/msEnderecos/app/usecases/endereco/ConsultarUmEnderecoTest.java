package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ConsultarUmEnderecoInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ConsultarUmEnderecoTest {

    @Mock
    private ConsultarUmEnderecoInterface consultarUmEnderecoInterface;

    @InjectMocks
    private ConsultarUmEndereco consultarUmEndereco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarUmEndereco() {
        Endereco expectedEndereco = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        when(consultarUmEnderecoInterface.consultarUmEndereco(anyLong())).thenReturn(expectedEndereco);

        Endereco actualEndereco = consultarUmEndereco.consultarUmEndereco(1L);

        assertEquals(expectedEndereco, actualEndereco);
    }
}
