package br.com.allen.flashlogistics.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allen.flashlogistics.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	public List<Client> findByName(String name);
	public List<Client> findByNameContainingIgnoreCase(String nome);
}
