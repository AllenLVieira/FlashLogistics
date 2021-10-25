package br.com.allen.flashlogistics.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.allen.flashlogistics.api.model.OcurrenceResponse;
import br.com.allen.flashlogistics.domain.model.Ocurrence;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcurrenceAssembler {
	private ModelMapper modelMapper;
	
	public OcurrenceResponse toModel(Ocurrence ocurrence) {
		return modelMapper.map(ocurrence, OcurrenceResponse.class);
	}
	
	public List<OcurrenceResponse> toCollectionModel(List<Ocurrence> ocurrences){
		return ocurrences.stream().map(this::toModel)
				.collect(Collectors.toList());
	}
}
