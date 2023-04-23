package ToyProject.PetCaringService.dto;

import ToyProject.PetCaringService.constant.PetGender;
import ToyProject.PetCaringService.constant.PetType;
import lombok.Data;

@Data
public class PetDto {
    private String name;
    private String email;
    private String petName;
    private PetType petType;
    private int age;
    private PetGender petGender;
}
