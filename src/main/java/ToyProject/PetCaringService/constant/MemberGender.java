package ToyProject.PetCaringService.constant;

import lombok.Getter;

@Getter
public enum MemberGender {
    FEMALE("FEMALE"), MALE("MALE");
    MemberGender(String value) {
        this.value = value;
    }
    private String value;
}
