package br.com.allen.flashlogistics.domain.service;

import org.springframework.stereotype.Service;

import br.com.allen.flashlogistics.domain.exception.EntityNotFoundException;
import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
	private DeliveryRepository deliveryRepository;
	
	public Delivery search(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotFoundException("Delivery ID not found."));
	}
}
