package com.fiap.msEnderecos.infra.gateways.endereco;

import com.fiap.msEnderecos.domain.entity.Endereco;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnderecoMapperTest {

    private final EnderecoMapper mapper = new EnderecoMapper();

    @Test
    void testToDomain() {
        EnderecoEntity entity = new EnderecoEntity(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        Endereco endereco = mapper.toDomain(entity);

        assertEquals(entity.getId(), endereco.getId());
        assertEquals(entity.getLogradouro(), endereco.getLogradouro());
        assertEquals(entity.getNumero(), endereco.getNumero());
        assertEquals(entity.getBairro(), endereco.getBairro());
        assertEquals(entity.getCidade(), endereco.getCidade());
        assertEquals(entity.getCep(), endereco.getCep());
        assertEquals(entity.getLatitude(), endereco.getLatitude());
        assertEquals(entity.getLongitude(), endereco.getLongitude());
    }

    @Test
    void testToEntity() {
        Endereco endereco = new Endereco(1L, "Rua A", "123", "Bairro B", "Cidade C", "12345-678", "-23.5505", "-46.6333");
        EnderecoEntity entity = mapper.toEntity(endereco);

        assertEquals(endereco.getId(), entity.getId());
        assertEquals(endereco.getLogradouro(), entity.getLogradouro());
        assertEquals(endereco.getNumero(), entity.getNumero());
        assertEquals(endereco.getBairro(), entity.getBairro());
        assertEquals(endereco.getCidade(), entity.getCidade());
        assertEquals(endereco.getCep(), entity.getCep());
        assertEquals(endereco.getLatitude(), entity.getLatitude());
        assertEquals(endereco.getLongitude(), entity.getLongitude());
    }
}