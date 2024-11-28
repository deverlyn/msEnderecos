package com.fiap.msEnderecos.infra.controller.endereco;

import com.fiap.msEnderecos.app.usecases.endereco.ConsultarUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.ExcluirUmEndereco;
import com.fiap.msEnderecos.app.usecases.endereco.RegistrarEndereco;
import com.fiap.msEnderecos.domain.entity.Endereco;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final ConsultarUmEndereco consultarUmEndereco;
    private final ExcluirUmEndereco excluirUmEndereco;
    private final RegistrarEndereco registrarEndereco;

    public EnderecoController(ConsultarUmEndereco consultarUmEndereco, ExcluirUmEndereco excluirUmEndereco, RegistrarEndereco registrarEndereco) {
        this.consultarUmEndereco = consultarUmEndereco;
        this.excluirUmEndereco = excluirUmEndereco;
        this.registrarEndereco = registrarEndereco;
    }

    @GetMapping("/{id}")
    public EnderecoDTO consultarEndereco(@PathVariable Long id){
        Endereco endereco = consultarUmEndereco.consultarUmEndereco(id);
        return new EnderecoDTO(endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getCep(),
                endereco.getLatitude(),
                endereco.getLongitude()
        );
    }

    @DeleteMapping("/{id}")
    public void excluirEndereco(@PathVariable Long id){
        excluirUmEndereco.excluirUmEndereco(id);
    }

    @PostMapping
    public EnderecoDTO cadastrarEndereco(@RequestBody EnderecoDTO dto){
        Endereco endereco = registrarEndereco.registrarEndereco(new Endereco(
                dto.id(),
                dto.logradouro(),
                dto.numero(),
                dto.bairro(),
                dto.cidade(),
                dto.cep(),
                dto.latitude(),
                dto.longitude()));

        return new EnderecoDTO(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getCep(),
                endereco.getLatitude(),
                endereco.getLongitude());

    }

}
