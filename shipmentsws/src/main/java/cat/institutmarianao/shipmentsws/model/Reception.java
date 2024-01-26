package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
/* Lombok */
@Data
@DiscriminatorValue(Action.RECEPTION)
@EqualsAndHashCode(callSuper = true)
public class Reception extends Action implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer trackingNumber;
}
