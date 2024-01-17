package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Lombok */
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@NotBlank
	@Size(max = 100)
	private String name;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String number;
	@NotBlank
	private String floor;
	@NotBlank
	private String door;
	@NotBlank
	private String city;
	@NotBlank
	private String province;
	@NotBlank
	private String postalCode;
	@NotBlank
	private String country;
}
