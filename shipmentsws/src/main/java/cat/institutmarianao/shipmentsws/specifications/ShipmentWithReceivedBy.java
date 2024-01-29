package cat.institutmarianao.shipmentsws.specifications;

import org.springframework.data.jpa.domain.Specification;

import cat.institutmarianao.shipmentsws.model.Shipment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ShipmentWithReceivedBy implements Specification<Shipment> {

	private static final long serialVersionUID = 1L;
	private String receivedBy ;

	public ShipmentWithReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	@Override
	public Predicate toPredicate(Root<Shipment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (receivedBy == null) {
			return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filtering
		}
		return criteriaBuilder.equal(root.get("receivedBy"), receivedBy.toString());
	}

}
