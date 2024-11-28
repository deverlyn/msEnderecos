package com.fiap.msEnderecos.infra.controller.endereco;

public record EnderecoDTO(
        Long id,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String cep,
        String latitude,
        String longitude
) {
}
