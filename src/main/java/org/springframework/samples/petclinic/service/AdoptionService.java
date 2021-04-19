package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.AdoptionRepository;
import org.springframework.samples.petclinic.repository.BookingRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
	public Collection<Integer> findOwnerByPetId(int petId){
		return this.adoptionRepository.findOwnerByPetId(petId);
	}
	
//	@Transactional(readOnly = true)
//	public List<Integer> findAlreadyAppliedPetsIdsByOwner(int ownerId){
//		return this.adoptionRepository.findAlreadyAppliedPetsIdsByOwner(ownerId);
//	}

	@Transactional
	public void saveAdoption(Adoption adoption){
        this.adoptionRepository.save(adoption);                
	}
	
	@Transactional
	public void delete(Adoption adoption) throws DataAccessException {
		this.adoptionRepository.delete(adoption);
	}
  

}
