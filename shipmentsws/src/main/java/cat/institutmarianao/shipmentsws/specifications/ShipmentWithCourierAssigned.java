package cat.institutmarianao.shipmentsws.specifications;

import org.springframework.data.jpa.domain.Specification;

import cat.institutmarianao.shipmentsws.model.Shipment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ShipmentWithCourierAssigned implements Specification<Shipment> {

	private static final long serialVersionUID = 1L;
	private String courierAssigned ;

	public ShipmentWithCourierAssigned(String courierAssigned) {
		this.courierAssigned = courierAssigned;
	}

	@Override
	public Predicate toPredicate(Root<Shipment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (courierAssigned == null) {
			return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filtering
		}
		return criteriaBuilder.equal(root.get("courierAssigned"), courierAssigned.toString());
	}

}
