package com.fiap.msEnderecos.infra.gateways.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.*;
import com.fiap.msEnderecos.domain.entity.Endereco;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoEntity;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeEnderecoJPA implements
        ConsultarUmEnderecoInterface,
        ExcluirUmEnderecoInterface,
        RegistrarEnderecoInterface,
        ValidaUmEnderecoInterface,
        ListarEnderecosInterface {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public RepositorioDeEnderecoJPA(EnderecoRepository repository, EnderecoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Endereco consultarUmEndereco(Long id) {
        EnderecoEntity entity = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Endereco Não Encontrado"));

        return mapper.toDomain(entity);
    }

    @Override
    public void excluirUmEnderecoInterface(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Endereco registrarEndereco(Endereco endereco) {
        EnderecoEntity entity = mapper.toEntity(endereco);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Boolean validaUmEndereco(Long id) {
        EnderecoEntity entity = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Endereco Não Encontrado"));

        return true;
    }

    @Override
    public List<Endereco> listarTodos() {
        List<EnderecoEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
