package com.fiap.msEnderecos.infra.gateways.endereco;

import com.fiap.msEnderecos.domain.entity.Endereco;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoEntity;

public class EnderecoMapper {

    public Endereco toDomain(EnderecoEntity input) {
        return new Endereco(input.getId(),
                input.getLogradouro(),
                input.getNumero(),
                input.getBairro(),
                input.getCidade(),
                input.getCep(),
                input.getLatitude(),
                input.getLongitude());
    }

    public EnderecoEntity toEntity(Endereco input) {
        return new EnderecoEntity(input.getId(),
                input.getLogradouro(),
                input.getNumero(),
                input.getBairro(),
                input.getCidade(),
                input.getCep(),
                input.getLatitude(),
                input.getLongitude());
    }
}
