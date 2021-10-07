package com.udacity.jdnd.course3.critter.pet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Updated by Brian Smith on 10/7/21.
 * Description: Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = new Pet(petDTO.getType(), petDTO.getName(), petDTO.getBirthDate(), petDTO.getNotes());

        return buildPetDTO(petService.save(pet, petDTO.getOwnerId()));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return buildPetDTO(petService.findPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<Pet> pets = petService.findAllPets();

        return pets.stream().map(this::buildPetDTO).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petService.findPetsByCustomerId(ownerId);

        return pets.stream().map(this::buildPetDTO).collect(Collectors.toList());
    }

    private PetDTO buildPetDTO(Pet pet) {
        return PetDTO.builder()
                .id(pet.getCustomer().getId())
                .type(pet.getType())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .notes(pet.getNotes())
                .build();
    }
}
