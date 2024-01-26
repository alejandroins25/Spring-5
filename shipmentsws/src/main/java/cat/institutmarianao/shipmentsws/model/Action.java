package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/*JPA*/
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@Table(name = "actions")
public abstract class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for type - MUST be constants */
	public static final String RECEPTION = "RECEPTION";
	public static final String ASSIGNMENT = "ASSIGNMENT";
	public static final String DELIVERY = "DELIVERY";

	public enum Type {
		RECEPTION, ASSIGNMENT, DELIVERY
	}

	/* Lombok */
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(insertable=false, updatable=false)
	protected Type type;

	@ManyToOne
	@JoinColumn(name = "performer_username")
	@NotNull
	protected User performer;
	
	@PastOrPresent
	protected Date date = new Date();

	@ManyToOne
    @JoinColumn(name = "shipment_id") 
	@NotNull
	protected Shipment shipment;
}
