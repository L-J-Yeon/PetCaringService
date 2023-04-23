package ToyProject.PetCaringService.constant;

import lombok.Getter;

@Getter
public enum PetGender {
    FEMALE("FEMALE"), MALE("MALE"), FEMALENEUTRALIZATION("FEMALENEUTRALIZATION"), MALENEUTRALIZATION("MALENEUTRALIZATION");
    PetGender(String value) {
        this.value = value;
    }
    private String value;
}
