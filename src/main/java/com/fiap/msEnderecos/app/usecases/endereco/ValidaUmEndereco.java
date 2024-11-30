package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ValidaUmEnderecoInterface;

public class ValidaUmEndereco {

    private final ValidaUmEnderecoInterface validaUmEnderecoInterface;

    public ValidaUmEndereco(ValidaUmEnderecoInterface validaUmEnderecoInterface) {
        this.validaUmEnderecoInterface = validaUmEnderecoInterface;
    }

    public Boolean validaEndereco(Long id){
        return validaUmEnderecoInterface.validaUmEndereco(id);
    }
}
