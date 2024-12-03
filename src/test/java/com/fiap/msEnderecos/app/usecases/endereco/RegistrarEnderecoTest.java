package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.RegistrarEnderecoInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RegistrarEnderecoTest {

    @Mock
    private RegistrarEnderecoInterface registrarEnderecoInterface;

    @InjectMocks
    private RegistrarEndereco registrarEndereco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarEndereco() {
        Endereco expectedEndereco = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        when(registrarEnderecoInterface.registrarEndereco(any(Endereco.class))).thenReturn(expectedEndereco);

        Endereco actualEndereco = registrarEndereco.registrarEndereco(expectedEndereco);

        assertEquals(expectedEndereco, actualEndereco);
    }
}