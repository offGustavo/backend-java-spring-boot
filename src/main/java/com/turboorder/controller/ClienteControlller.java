
package com.turboorder.controller;

import com.turboorder.dto.ClientDTO;
import com.turboorder.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

  private final ClientService service;

  public ClientController(ClientService service) {
    this.service = service;
  }

  @GetMapping
  public List<ClientDTO> getAllClients() {
    return service.getAllClients();
  }

  @PostMapping
  public ClientDTO addClient(@RequestBody ClientDTO dto) {
    return service.addClient(dto);
  }

  @PutMapping("/{cliId}")
  public void updateClient(@PathVariable Integer cliId, @RequestBody ClientDTO dto) {
    service.updateClient(cliId, dto);
  }

  @DeleteMapping("/{cliId}")
  public void deleteClient(@PathVariable Integer cliId) {
    service.deleteClient(cliId);
  }

  @GetMapping("/phone/{telefone}")
  public ClientDTO getClientByPhone(@PathVariable String telefone) {
    return service.getClientByPhone(telefone);
  }

  @GetMapping("/phone-suggestions/{partialTelefone}")
  public List<String> getPhoneSuggestions(@PathVariable String partialTelefone) {
    return service.getPhoneSuggestions(partialTelefone);
  }
}
