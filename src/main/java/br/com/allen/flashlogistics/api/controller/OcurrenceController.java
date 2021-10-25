package br.com.allen.flashlogistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.allen.flashlogistics.api.assembler.OcurrenceAssembler;
import br.com.allen.flashlogistics.api.model.OcurrenceRequest;
import br.com.allen.flashlogistics.api.model.OcurrenceResponse;
import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.model.Ocurrence;
import br.com.allen.flashlogistics.domain.service.OcurrenceRegistryService;
import br.com.allen.flashlogistics.domain.service.SearchDeliveryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/ocurrences")
public class OcurrenceController {
	private SearchDeliveryService searchDeliveryService;
	private OcurrenceRegistryService ocurrenceRegService;
	private OcurrenceAssembler ocurrenceAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcurrenceResponse addRegistry(@PathVariable Long deliveryId, @Valid @RequestBody OcurrenceRequest request) {
		Ocurrence ocurrenceReg = ocurrenceRegService.addRegistry(deliveryId, request.getDescription());
		return ocurrenceAssembler.toModel(ocurrenceReg);
	}
	
	@GetMapping
	public List<OcurrenceResponse> getAllOcurrencesByDeliveryId(@PathVariable Long deliveryId){
		Delivery delivery = searchDeliveryService.search(deliveryId);
		return ocurrenceAssembler.toCollectionModel(delivery.getOcurrences());
	}
}
