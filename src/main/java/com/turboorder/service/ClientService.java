
package com.turboorder.service;

import com.turboorder.dto.ClienteDTO;
import com.turboorder.model.Cliente;
import com.turboorder.model.Contato;
import com.turboorder.model.Endereco;
import com.turboorder.repository.ClienteRepository;
import com.turboorder.repository.ContatoRepository;
import com.turboorder.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

  private final ClienteRepository clienteRepository;
  private final ContatoRepository contatoRepository;
  private final EnderecoRepository enderecoRepository;

  public ClientService(ClienteRepository clienteRepository, ContatoRepository contatoRepository,
      EnderecoRepository enderecoRepository) {
    this.clienteRepository = clienteRepository;
    this.contatoRepository = contatoRepository;
    this.enderecoRepository = enderecoRepository;
  }

  public List<ClienteDTO> getAllClients() {
    return clienteRepository.findAllByCliAtivoTrue()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public ClienteDTO getClientByPhone(String telefone) {
    Cliente cliente = clienteRepository.findByContato_ConTelefoneAndCliAtivoTrue(telefone)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    return convertToDTO(cliente);
  }

  public List<String> getPhoneSuggestions(String partialTelefone) {
    return contatoRepository.findTop10ByConTelefoneContaining(partialTelefone)
        .stream()
        .map(Contato::getConTelefone)
        .collect(Collectors.toList());
  }

  public ClienteDTO addClient(ClienteDTO dto) {
    Endereco endereco = new Endereco();
    endereco.setEndCep(dto.getCliCep());
    endereco.setEndCidade(dto.getCliCidade());
    endereco.setEndBairro(dto.getCliBairro());
    endereco.setEndRua(dto.getCliEndereco());
    endereco = enderecoRepository.save(endereco);

    Contato contato = new Contato();
    contato.setConTelefone(dto.getConTelefone());
    contato = contatoRepository.save(contato);

    Cliente cliente = new Cliente();
    cliente.setCliNome(dto.getCliNome());
    cliente.setCliSobrenome(dto.getCliSobrenome());
    cliente.setCliNumero(dto.getCliNumero());
    cliente.setCliComplemento(dto.getCliComplemento());
    cliente.setEmpresaFk(dto.getCliId()); // cuidado aqui
    cliente.setEndereco(endereco);
    cliente.setContato(contato);

    cliente = clienteRepository.save(cliente);

    return convertToDTO(cliente);
  }

  public void updateClient(Integer cliId, ClienteDTO dto) {
    Cliente cliente = clienteRepository.findById(cliId)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    cliente.setCliNome(dto.getCliNome());
    cliente.setCliSobrenome(dto.getCliSobrenome());
    cliente.setCliNumero(dto.getCliNumero());
    cliente.setCliComplemento(dto.getCliComplemento());

    cliente.getContato().setConTelefone(dto.getConTelefone());
    cliente.getEndereco().setEndCep(dto.getCliCep());
    cliente.getEndereco().setEndCidade(dto.getCliCidade());
    cliente.getEndereco().setEndBairro(dto.getCliBairro());
    cliente.getEndereco().setEndRua(dto.getCliEndereco());

    contatoRepository.save(cliente.getContato());
    enderecoRepository.save(cliente.getEndereco());
    clienteRepository.save(cliente);
  }

  public void deleteClient(Integer cliId) {
    Cliente cliente = clienteRepository.findById(cliId)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    cliente.setCliAtivo(false);
    clienteRepository.save(cliente);
  }

  private ClienteDTO convertToDTO(Cliente cliente) {
    ClienteDTO dto = new ClienteDTO();
    dto.setCliId(cliente.getCliId());
    dto.setCliNome(cliente.getCliNome());
    dto.setCliSobrenome(cliente.getCliSobrenome());
    dto.setCliNumero(cliente.getCliNumero());
    dto.setCliComplemento(cliente.getCliComplemento());
    dto.setConTelefone(cliente.getContato().getConTelefone());
    dto.setCliCep(cliente.getEndereco().getEndCep());
    dto.setCliEndereco(cliente.getEndereco().getEndRua());
    dto.setCliBairro(cliente.getEndereco().getEndBairro());
    dto.setCliCidade(cliente.getEndereco().getEndCidade());
    return dto;
  }
}
