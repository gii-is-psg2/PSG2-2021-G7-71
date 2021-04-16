package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adoptions")
public class Adoption extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	public void setPet(Pet pet) {
		this.pet=pet;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public void setOwner(Owner owner) {
		this.owner=owner;
	}
	
	public Owner getOwner() {
		return this.owner;
	}

}
