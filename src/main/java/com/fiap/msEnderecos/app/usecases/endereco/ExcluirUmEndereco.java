package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ExcluirUmEnderecoInterface;

public class ExcluirUmEndereco {

    private final ExcluirUmEnderecoInterface excluirUmEndereco;

    public ExcluirUmEndereco(ExcluirUmEnderecoInterface excluirUmEndereco) {
        this.excluirUmEndereco = excluirUmEndereco;
    }

    public void excluirUmEndereco(Long id) {
        excluirUmEndereco.excluirUmEnderecoInterface(id);
    }
}
