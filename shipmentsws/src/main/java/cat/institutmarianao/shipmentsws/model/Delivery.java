package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
/* Lombok */
@Data
@DiscriminatorValue(Action.DELIVERY)
@EqualsAndHashCode(callSuper = true)
public class Delivery extends Action implements Serializable {

	private static final long serialVersionUID = 1L;
}
