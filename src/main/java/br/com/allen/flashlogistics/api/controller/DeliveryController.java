package br.com.allen.flashlogistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.repository.DeliveryRepository;
import br.com.allen.flashlogistics.domain.service.DeliveryRequestsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	private DeliveryRepository deliveryRepository;
	private DeliveryRequestsService deliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery requestDelivery(@Valid @RequestBody Delivery delivery) {
		return deliveryService.create(delivery);
	}
	
	@GetMapping
	public List<Delivery> getAllDeliveryRequests(){
		return deliveryRepository.findAll();
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<Delivery> getById(@PathVariable Long deliveryId){
		return deliveryRepository.findById(deliveryId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
