package cat.institutmarianao.shipmentsws.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithCategory;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithCourierAssigned;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithFrom;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithReceivedBy;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithStatus;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithTo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Service
public class ShipmentServiceImpl implements ShipmentService{
	
	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll() {
		return shipmentRepository.findAll();
	}
	
	@Override
	public List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category,
			Date from, Date to) {
		Specification<Shipment> spec = Specification.where(new ShipmentWithStatus(status));
		//Specification<Shipment> spec = Specification.where(new ShipmentWithStatus(status), new ShipmentWithReceivedBy(receivedBy), new ShipmentWithCourierAssigned(courierAssigned), new ShipmentWithCategory(category), new ShipmentWithFrom(from), new ShipmentWithTo(to));
		return shipmentRepository.findAll(spec);
	}

	@Override
	public Shipment getById(@Positive Long shipmentId) {
		return shipmentRepository.findById(shipmentId).orElseThrow(NotFoundException::new);
	}

	@Override
    public Shipment saveShipment(@Valid Shipment shipment) {
        return shipmentRepository.saveAndFlush(shipment);
    }
	
	@Override
    public void deleteById(@NotBlank Long id) {
    	shipmentRepository.deleteById(id);
    }

    @Override
    public void deleteShipmentById(@Positive Long shipmentId) {
    	shipmentRepository.deleteById(shipmentId);
    }

}