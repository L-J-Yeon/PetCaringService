package ToyProject.PetCaringService.service;

import ToyProject.PetCaringService.constant.PetGender;
import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }


}
