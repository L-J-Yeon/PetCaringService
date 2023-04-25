package ToyProject.PetCaringService.service;

import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
}
