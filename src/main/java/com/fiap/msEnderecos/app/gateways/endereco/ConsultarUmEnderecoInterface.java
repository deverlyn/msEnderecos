package com.fiap.msEnderecos.app.gateways.endereco;

import com.fiap.msEnderecos.domain.entity.Endereco;

public interface ConsultarUmEnderecoInterface {

    Endereco consultarUmEndereco(Long id);
}
