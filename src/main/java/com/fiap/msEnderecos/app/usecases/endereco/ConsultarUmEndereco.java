package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ConsultarUmEnderecoInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;

public class ConsultarUmEndereco {

    private final ConsultarUmEnderecoInterface consultarUmEnderecoInterface;

    public ConsultarUmEndereco(ConsultarUmEnderecoInterface consultarUmEnderecoInterface) {
        this.consultarUmEnderecoInterface = consultarUmEnderecoInterface;
    }

    public Endereco consultarUmEndereco(Long id) {
        return consultarUmEnderecoInterface.consultarUmEndereco(id);
    }
}
