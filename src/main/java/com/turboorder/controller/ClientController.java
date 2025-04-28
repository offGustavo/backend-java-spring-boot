
package com.turboorder.controller;

import com.turboorder.dto.ClienteDTO;
import com.turboorder.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

  private final ClientService service;

  public ClientController(ClientService service) {
    this.service = service;
  }

  @GetMapping
  public List<ClienteDTO> getAllClients() {
    return service.getAllClients();
  }

  @PostMapping
  public ClienteDTO addClient(@RequestBody ClienteDTO dto) {
    return service.addClient(dto);
  }

  @PutMapping("/{cliId}")
  public void updateClient(@PathVariable Integer cliId, @RequestBody ClienteDTO dto) {
    service.updateClient(cliId, dto);
  }

  @DeleteMapping("/{cliId}")
  public void deleteClient(@PathVariable Integer cliId) {
    service.deleteClient(cliId);
  }

  @GetMapping("/telefone/{telefone}")
  public ClienteDTO getClientByPhone(@PathVariable String telefone) {
    return service.getClientByPhone(telefone);
  }

  @GetMapping("/telefone-sugestoes/{partialTelefone}")
  public List<String> getPhoneSuggestions(@PathVariable String partialTelefone) {
    return service.getPhoneSuggestions(partialTelefone);
  }
}
