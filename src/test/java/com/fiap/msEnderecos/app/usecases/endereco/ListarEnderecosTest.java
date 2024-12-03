package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ListarEnderecosInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListarEnderecosTest {

    @Mock
    private ListarEnderecosInterface listarEnderecosInterface;

    @InjectMocks
    private ListarEnderecos listarEnderecos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {
        Endereco endereco1 = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        Endereco endereco2 = new Endereco(2L, "Rua B", "456", "Bairro D", "Cidade E", "98765-432", "-23.5506", "-46.6334");

        when(listarEnderecosInterface.listarTodos()).thenReturn(Arrays.asList(endereco1, endereco2));

        List<Endereco> result = listarEnderecos.listarTodos();

        assertEquals(2, result.size());
        assertEquals(endereco1, result.get(0));
        assertEquals(endereco2, result.get(1));
    }
}
