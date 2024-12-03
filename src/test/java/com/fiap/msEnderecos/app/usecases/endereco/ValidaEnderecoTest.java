package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ValidaUmEnderecoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ValidaUmEnderecoTest {

    @Mock
    private ValidaUmEnderecoInterface validaUmEnderecoInterface;

    @InjectMocks
    private ValidaUmEndereco validaUmEndereco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidaEndereco() {
        when(validaUmEnderecoInterface.validaUmEndereco(anyLong())).thenReturn(true);

        Boolean isValid = validaUmEndereco.validaEndereco(1L);

        assertTrue(isValid);
    }
}