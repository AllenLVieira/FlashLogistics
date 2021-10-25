package br.com.allen.flashlogistics.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.allen.flashlogistics.domain.exception.BusinessException;
import br.com.allen.flashlogistics.domain.model.Client;
import br.com.allen.flashlogistics.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientCatalogService {
	private ClientRepository repository;
	
	@Transactional
	public Client save(Client client) {
		boolean existentEmail = repository.findByEmail(client.getEmail())
				.stream().anyMatch(existentClient -> !existentClient.equals(client));
		if(existentEmail) {
			throw new BusinessException("This email is already registered.");
		}
		return repository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		repository.deleteById(clientId);
	}
}
