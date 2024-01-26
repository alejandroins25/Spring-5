package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
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
