package com.fiap.msEnderecos.config;

import com.fiap.msEnderecos.app.gateways.endereco.ConsultarUmEnderecoInterface;
import com.fiap.msEnderecos.app.gateways.endereco.ExcluirUmEnderecoInterface;
import com.fiap.msEnderecos.app.gateways.endereco.RegistrarEnderecoInterface;
import com.fiap.msEnderecos.app.gateways.endereco.ValidaUmEnderecoInterface;
import com.fiap.msEnderecos.app.usecases.endereco.ConsultarUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.ExcluirUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.RegistrarEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.ValidaUmEndereco;
import com.fiap.msEnderecos.infra.gateways.endereco.EnderecoMapper;
import com.fiap.msEnderecos.infra.gateways.endereco.RepositorioDeEnderecoJPA;
import com.fiap.msEnderecos.infra.persistence.endereco.EnderecoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EnderecoConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void testBeansPresence() {
        assertNotNull(context.getBean(ConsultarUmEndereco.class));
        assertNotNull(context.getBean(ExcluirUmEndereco.class));
        assertNotNull(context.getBean(RegistrarEndereco.class));
        assertNotNull(context.getBean(ValidaUmEndereco.class));
        assertNotNull(context.getBean(RepositorioDeEnderecoJPA.class));
        assertNotNull(context.getBean(EnderecoMapper.class));
    }
}