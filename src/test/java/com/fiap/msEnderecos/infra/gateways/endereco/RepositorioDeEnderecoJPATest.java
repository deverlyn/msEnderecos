package com.fiap.msEnderecos.infra.gateways.endereco;

import com.fiap.msEnderecos.domain.entity.Endereco;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoEntity;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RepositorioDeEnderecoJPATest {

    @Mock
    private EnderecoRepository repository;

    @Mock
    private EnderecoMapper mapper;

    @InjectMocks
    private RepositorioDeEnderecoJPA repositorioDeEnderecoJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarUmEndereco() {
        Long id = 1L;
        EnderecoEntity entity = new EnderecoEntity();
        Endereco endereco = new Endereco();

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(endereco);

        Endereco result = repositorioDeEnderecoJPA.consultarUmEndereco(id);

        assertEquals(endereco, result);
        verify(repository).findById(id);
        verify(mapper).toDomain(entity);
    }

    @Test
    void testExcluirUmEnderecoInterface() {
        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        repositorioDeEnderecoJPA.excluirUmEnderecoInterface(id);

        verify(repository).deleteById(id);
    }

    @Test
    void testRegistrarEndereco() {
        Endereco endereco = new Endereco();
        EnderecoEntity entity = new EnderecoEntity();

        when(mapper.toEntity(endereco)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(endereco);

        Endereco result = repositorioDeEnderecoJPA.registrarEndereco(endereco);

        assertEquals(endereco, result);
        verify(mapper).toEntity(endereco);
        verify(repository).save(entity);
        verify(mapper).toDomain(entity);
    }

    @Test
    void testValidaUmEndereco() {
        Long id = 1L;
        EnderecoEntity entity = new EnderecoEntity();

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        Boolean result = repositorioDeEnderecoJPA.validaUmEndereco(id);

        assertTrue(result);
        verify(repository).findById(id);
    }
    @Test
    void testListarTodos() {
        EnderecoEntity entity1 = new EnderecoEntity();
        EnderecoEntity entity2 = new EnderecoEntity();
        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();

        when(repository.findAll()).thenReturn(Arrays.asList(entity1, entity2));
        when(mapper.toDomain(entity1)).thenReturn(endereco1);
        when(mapper.toDomain(entity2)).thenReturn(endereco2);

        List<Endereco> result = repositorioDeEnderecoJPA.listarTodos();

        assertEquals(2, result.size());
        assertEquals(endereco1, result.get(0));
        assertEquals(endereco2, result.get(1));
    }
}