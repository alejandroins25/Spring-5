package cat.institutmarianao.shipmentsws.services.impl;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import jakarta.validation.constraints.Positive;

public class ShipmentServiceImpl implements ShipmentService{


	@Override
	public List<Shipment> findAllPending(String receivedBy, String courierAssigned, String category, String from,
			String to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipment> findAllInProcess(String receivedBy, String courierAssigned, String category, String from,
			String to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment getById(@Positive Long shipmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category,
			Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

}
