package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ExcluirUmEnderecoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class ExcluirUmEnderecoTest {

    @Mock
    private ExcluirUmEnderecoInterface excluirUmEnderecoInterface;

    @InjectMocks
    private ExcluirUmEndereco excluirUmEndereco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExcluirUmEndereco() {
        Long id = 1L;
        doNothing().when(excluirUmEnderecoInterface).excluirUmEnderecoInterface(id);

        excluirUmEndereco.excluirUmEndereco(id);

        verify(excluirUmEnderecoInterface).excluirUmEnderecoInterface(id);
    }
}