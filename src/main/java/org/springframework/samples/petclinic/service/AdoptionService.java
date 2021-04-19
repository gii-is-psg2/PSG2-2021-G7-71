package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.AdoptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionService {

	private AdoptionRepository adoptionRepository;
		
	@Autowired
	public AdoptionService(AdoptionRepository adoptionRepository) {
		this.adoptionRepository = adoptionRepository;
	}


	@Transactional(readOnly = true)
	public Iterable<Adoption> findByPet(Pet pet) throws DataAccessException {
		return this.adoptionRepository.findByPet(pet);
	}
	
	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByPetId(int petId){
		return this.adoptionRepository.findOwnerByPetId(petId);
	}
	


    @Transactional(readOnly = true)
    public Iterable<Pet> findAlreadyAppliedPetsIdsByOwner(int ownerId){
    	
        return this.adoptionRepository.findAlreadyAppliedPetsIdsByOwner(ownerId);
    }
    @Transactional(readOnly = true)
    public Adoption findByOwnerAndPet(int ownerId,int petId){
    	
        return this.adoptionRepository.findByOwnerAndPet(ownerId,petId);
    }
    
	@Transactional
	public void saveAdoption(Adoption adoption){
        this.adoptionRepository.save(adoption);                
	}
	
	@Transactional
	public void delete(Adoption adoption) throws DataAccessException {
		this.adoptionRepository.delete(adoption);
	}
  

}
