package br.com.allen.flashlogistics.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allen.flashlogistics.domain.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
