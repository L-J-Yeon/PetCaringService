package ToyProject.PetCaringService.domain;

import ToyProject.PetCaringService.constant.PetGender;
import ToyProject.PetCaringService.constant.PetType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

}
