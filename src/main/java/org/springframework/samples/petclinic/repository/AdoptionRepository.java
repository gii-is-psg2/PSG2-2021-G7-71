package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;


public interface AdoptionRepository extends Repository<Adoption, Integer> {

	Iterable<Adoption> findByPet(Pet pet) throws DataAccessException;
	
	@Query(value = "SELECT a.owner FROM Adoption a WHERE a.pet.id = :petId")
	Collection<Owner> findOwnerByPetId(@Param("petId") Integer petId) throws DataAccessException;
	
	@Query(value = "SELECT a.pet FROM Adoption a WHERE a.owner.id = :ownerId")
	Collection<Pet> findAlreadyAppliedPetsIdsByOwner(@Param("ownerId") Integer ownerId) throws DataAccessException;
	
	void save(Adoption adoption) throws DataAccessException;
	
	void delete(Adoption adoption) throws DataAccessException;
}
