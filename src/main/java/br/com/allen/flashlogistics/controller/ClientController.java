package br.com.allen.flashlogistics.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.allen.flashlogistics.domain.model.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@GetMapping
	public List<Client> getAll() {
		Client a = new Client();
		a.setId(1L);
		a.setName("Allen");
		a.setEmail("allenvieira96@gmail.com");
		a.setPhone("1195949-2409");
		return Arrays.asList(a);
	}
}
