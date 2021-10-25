package br.com.allen.flashlogistics.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryCompletionService {
	private SearchDeliveryService searchDeliveryService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public void finishDelivery(@PathVariable Long deliveryId) {
		Delivery delivery = searchDeliveryService.search(deliveryId);
		delivery.finish();
		deliveryRepository.save(delivery);
	}
}
