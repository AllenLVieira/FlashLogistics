package br.com.allen.flashlogistics.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.allen.flashlogistics.domain.model.Client;
import br.com.allen.flashlogistics.domain.model.Delivery;
import br.com.allen.flashlogistics.domain.model.DeliveryStatus;
import br.com.allen.flashlogistics.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryRequestsService {
	private DeliveryRepository deliveryRepository;
	private ClientCatalogService clientCatalogService;
	
	@Transactional
	public Delivery create(Delivery delivery) {
		Client client = clientCatalogService.find(delivery.getClient().getId());
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setRequestDate(OffsetDateTime.now());
		return deliveryRepository.save(delivery);
	}
}
