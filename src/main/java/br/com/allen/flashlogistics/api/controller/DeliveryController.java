package br.com.allen.flashlogistics.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.service.DeliveryRequestsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	private DeliveryRequestsService deliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery requestDelivery(@RequestBody Delivery delivery) {
		return deliveryService.create(delivery);
	}
}
