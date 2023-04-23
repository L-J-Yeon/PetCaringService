package ToyProject.PetCaringService.repository;

import ToyProject.PetCaringService.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
