package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public interface ShipmentService {
	
	List<Shipment> findAll();

	Shipment getById(@Positive Long shipmentId);

	Shipment saveShipment(@Valid Shipment shipment);
	
	void deleteById(@NotBlank Long id);

	void deleteShipmentById(@Positive Long shipmentId);
	
}
