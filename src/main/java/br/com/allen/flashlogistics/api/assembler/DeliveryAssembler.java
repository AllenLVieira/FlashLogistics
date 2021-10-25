package br.com.allen.flashlogistics.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.allen.flashlogistics.api.model.DeliveryRequest;
import br.com.allen.flashlogistics.api.model.DeliveryResponse;
import br.com.allen.flashlogistics.domain.model.Delivery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {
	private ModelMapper modelMapper;
	
	public DeliveryResponse toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryResponse.class);
	}
	
	public List<DeliveryResponse> toCollectionModel(List<Delivery> delivery){
		return delivery.stream().map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryRequest request) {
		return modelMapper.map(request, Delivery.class);
	}
}
