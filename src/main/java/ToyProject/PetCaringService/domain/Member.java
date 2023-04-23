package ToyProject.PetCaringService.domain;

import ToyProject.PetCaringService.constant.MemberGender;
import ToyProject.PetCaringService.constant.Role;
import ToyProject.PetCaringService.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String name;
    private String address;
    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberGender memberGender;

    private LocalDate regDate;
    private LocalDate updDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Pet> petList = new ArrayList<>();

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setEmail(memberDto.getEmail());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setAddress(memberDto.getAddress());
        member.setPhone(memberDto.getPhone());
        member.setMemberGender(memberDto.getMemberGender());
        member.setRole(Role.MEMBER);
        return member;
    }
}
