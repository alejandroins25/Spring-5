package cat.institutmarianao.shipmentsws.services;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import jakarta.validation.constraints.Positive;

public interface ShipmentService {
	
	List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category, Date from, Date to);
	
	List<Shipment> findAllPending(String receivedBy, String courierAssigned, String category, String from, String to);
	
	List<Shipment> findAllInProcess(String receivedBy, String courierAssigned, String category, String from, String to);

	Shipment getById(@Positive Long shipmentId);
	
}
