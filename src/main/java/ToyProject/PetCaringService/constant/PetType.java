package ToyProject.PetCaringService.constant;

import lombok.Getter;

@Getter
public enum PetType {
    SMALL("SAMLL"), MIDDLE("MIDDLE"), LARGE("LARGE"), CAT("CAT");
    PetType(String value) {
        this.value = value;
    }
    private String value;
}
