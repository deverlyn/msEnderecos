package com.fiap.msEnderecos.app.usecases.endereco;

import com.fiap.msEnderecos.app.gateways.endereco.ListarEnderecosInterface;
import com.fiap.msEnderecos.domain.entity.Endereco;

import java.util.List;

public class ListarEnderecos {
    private final ListarEnderecosInterface listarTodosEnderecosInterface;

    public ListarEnderecos(ListarEnderecosInterface listarEnderecosInterface) {
        this.listarTodosEnderecosInterface = listarEnderecosInterface;
    }

    public List<Endereco> listarTodos() {
        return listarTodosEnderecosInterface.listarTodos();
    }
}
