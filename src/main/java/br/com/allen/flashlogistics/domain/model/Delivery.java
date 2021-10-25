package br.com.allen.flashlogistics.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.allen.flashlogistics.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private Client client;
	
	@Valid
	@NotNull
	@Embedded
	private Receiver receiver;
	
	@NotNull
	private BigDecimal fee;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Ocurrence> ocurrences = new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime requestDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime deliveryDate;

	public Ocurrence addOcurrence(String description) {
		Ocurrence ocurrence = new Ocurrence();
		ocurrence.setDescription(description);
		ocurrence.setOcurrenceDate(OffsetDateTime.now());
		ocurrence.setDelivery(this);
		this.getOcurrences().add(ocurrence);
		return ocurrence;
	}
}
