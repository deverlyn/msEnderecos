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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoConfig {

    @Bean
    ConsultarUmEndereco consultarUmEndereco(ConsultarUmEnderecoInterface consultarUmEndereco){
        return new ConsultarUmEndereco(consultarUmEndereco);
    }

    @Bean
    ExcluirUmEndereco excluirUmEndereco(ExcluirUmEnderecoInterface excluirUmEndereco){
        return new ExcluirUmEndereco(excluirUmEndereco);
    }

    @Bean
    RegistrarEndereco registrarEndereco(RegistrarEnderecoInterface registrarEndereco){
        return new RegistrarEndereco(registrarEndereco);
    }

    @Bean
    ValidaUmEndereco validaUmEndereco(ValidaUmEnderecoInterface validaUmEnderecoInterface){
        return new ValidaUmEndereco(validaUmEnderecoInterface);
    }

    @Bean
    RepositorioDeEnderecoJPA repositorioDeEnderecoJPA(EnderecoRepository enderecoRepository, EnderecoMapper mapper){
        return new RepositorioDeEnderecoJPA(enderecoRepository, mapper);
    }

    @Bean
    EnderecoMapper enderecoMapper(){
        return new EnderecoMapper();
    }
}
