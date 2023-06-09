package ToyProject.PetCaringService.dto;

import ToyProject.PetCaringService.constant.MemberGender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
public class MemberDto {
    @NotEmpty(message = "이메일은 필수 입력 값입니다")
    @Email(message = "이메일 형식으로 입력하세요")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다")
    @Length(message = "비밀번호는 8자 이상, 16자 이하로 입력하세요", min = 8, max = 16)
    private String password;

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;

    @NotEmpty(message = "주소는 필수 입력 값입니다")
    private String address;

    @NotEmpty(message = "전화번호는 필수 입력 값입니다")
    private String phone;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "성별을 체크하세요")
    private MemberGender memberGender;

}
