package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.RegistrarEnderecoInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;

public class RegistrarEndereco {

    private final RegistrarEnderecoInterface registrarEnderecoInterface;

    public RegistrarEndereco(RegistrarEnderecoInterface registrarEnderecoInterface) {
        this.registrarEnderecoInterface = registrarEnderecoInterface;
    }

    public Endereco registrarEndereco(Endereco endereco) {
        return registrarEnderecoInterface.registrarEndereco(endereco);
    }
}
