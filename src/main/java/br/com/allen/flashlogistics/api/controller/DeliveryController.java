package br.com.allen.flashlogistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.allen.flashlogistics.api.assembler.DeliveryAssembler;
import br.com.allen.flashlogistics.api.model.DeliveryRequest;
import br.com.allen.flashlogistics.api.model.DeliveryResponse;
import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.repository.DeliveryRepository;
import br.com.allen.flashlogistics.domain.service.DeliveryCompletionService;
import br.com.allen.flashlogistics.domain.service.DeliveryRequestsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	private DeliveryRepository deliveryRepository;
	private DeliveryRequestsService deliveryService;
	private DeliveryCompletionService deliveryCompletionService;
	private DeliveryAssembler deliveryAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryResponse requestDelivery(@Valid @RequestBody DeliveryRequest delivery) {
		Delivery newDelivery = deliveryAssembler.toEntity(delivery);
		Delivery deliveryRequest = deliveryService.create(newDelivery);
		return deliveryAssembler.toModel(deliveryRequest);
	}
	
	@GetMapping
	public List<DeliveryResponse> getAllDeliveryRequests(){
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryResponse> getById(@PathVariable Long deliveryId){
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/finish")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finish(@PathVariable Long deliveryId) {
		deliveryCompletionService.finishDelivery(deliveryId);
	}
}
