package ToyProject.PetCaringService.service;

import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.repository.MemberRepository;
import ToyProject.PetCaringService.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyPageService {
    private final MemberRepository memberRepository;
    private final PetRepository petRepository;

    public Member findMemberById(Long id) {
        return memberRepository.getById(id);
    }

    @Transactional
    public boolean createPet(Member member, Pet pet) {
        List<Pet> petList = member.getPetList();
        for (Pet p : petList) {
            if (p.getPetName() == pet.getPetName()) {
                return false;
            }
        }
        pet.setMember(member);
        petRepository.save(pet);
        return true;
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).get();
    }
}
