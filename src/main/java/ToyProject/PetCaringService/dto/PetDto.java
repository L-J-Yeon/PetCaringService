package ToyProject.PetCaringService.dto;

import ToyProject.PetCaringService.constant.PetGender;
import ToyProject.PetCaringService.constant.PetType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetDto {
    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String petName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "반려동물 종류를 선택하세요")
    private PetType petType;
    
    @NotNull(message = "반려동물 나이를 입력하세요")
    private int age;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "반려동물 성별을 선택하세요")
    private PetGender petGender;
}
