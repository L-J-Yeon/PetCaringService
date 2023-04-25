package ToyProject.PetCaringService.domain;

import ToyProject.PetCaringService.constant.PetGender;
import ToyProject.PetCaringService.constant.PetType;
import ToyProject.PetCaringService.dto.PetDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String petName;

    @Enumerated(EnumType.STRING)
    private PetGender petGender;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    private Integer age;
    private LocalDate regDate;
    private LocalDate updDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId")
    private Member member;

    public static Pet registerPet(PetDto petDto, Member member) {
        Pet pet = new Pet();
        pet.setPetName(petDto.getPetName());
        pet.setPetType(petDto.getPetType());
        pet.setAge(petDto.getAge());
        pet.setPetGender(petDto.getPetGender());
        pet.setMember(member);
        return pet;
    }

}
