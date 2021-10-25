package br.com.allen.flashlogistics.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.model.Ocurrence;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OcurrenceRegistryService {
	private SearchDeliveryService searchDeliveryService;
	
	@Transactional
	public Ocurrence addRegistry(Long deliveryId, String description) {
		Delivery delivery = searchDeliveryService.search(deliveryId);
		return delivery.addOcurrence(description);
	}
}
