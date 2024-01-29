package cat.institutmarianao.shipmentsws.services;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public interface ShipmentService {
	
	List<Shipment> findAll();
	
	List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category, Date from, Date to);

	Shipment getById(@Positive Long shipmentId);

	Shipment saveShipment(@Valid Shipment shipment);
	
	void deleteById(@NotBlank Long id);

	void deleteShipmentById(@Positive Long shipmentId);
	
}