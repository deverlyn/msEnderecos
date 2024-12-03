package com.fiap.msEnderecos.infra.controller.endereco;

import com.fiap.msEnderecos.app.usecases.endereco.*;
import com.fiap.msEnderecos.domain.entity.Endereco;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereços", description = "Endpoints para gerenciamento de endereços")
public class EnderecoController {

    private final ConsultarUmEndereco consultarUmEndereco;
    private final ExcluirUmEndereco excluirUmEndereco;
    private final RegistrarEndereco registrarEndereco;
    private final ValidaUmEndereco validaUmEndereco;

    private final ListarEnderecos listarTodosEnderecos;

    public EnderecoController(ConsultarUmEndereco consultarUmEndereco, ExcluirUmEndereco excluirUmEndereco, RegistrarEndereco registrarEndereco, ValidaUmEndereco validaUmEndereco, ListarEnderecos listarTodosEnderecos) {
        this.consultarUmEndereco = consultarUmEndereco;
        this.excluirUmEndereco = excluirUmEndereco;
        this.registrarEndereco = registrarEndereco;
        this.validaUmEndereco = validaUmEndereco;
        this.listarTodosEnderecos = listarTodosEnderecos;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar um Endereço", description = "Consulta um Endereço existente.")
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
    @Operation(summary = "Excluir Endereço", description = "Exclui um endereço.")
    public void excluirEndereco(@PathVariable Long id){
        excluirUmEndereco.excluirUmEndereco(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar Endereço", description = "Cadastra um novo endereço.")
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

    @GetMapping("/consultar/{id}")
    @Operation(summary = "Validar Endereço", description = "Valida se o endereço é existente.")
    public Boolean validaEndereco(@PathVariable Long id){
        return validaUmEndereco.validaEndereco(id);
    }
    @GetMapping
    @Operation(summary = "Listar todos os Endereços", description = "Lista todos os endereços cadastrados.")
    public List<EnderecoDTO> listarTodosEnderecos() {
        List<Endereco> enderecos = listarTodosEnderecos.listarTodos();
        return enderecos.stream()
                .map(endereco -> new EnderecoDTO(
                        endereco.getId(),
                        endereco.getLogradouro(),
                        endereco.getNumero(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getCep(),
                        endereco.getLatitude(),
                        endereco.getLongitude()))
                .collect(Collectors.toList());
    }
}

