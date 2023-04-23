package ToyProject.PetCaringService.controller;

import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.dto.MemberDto;
import ToyProject.PetCaringService.repository.MemberRepository;
import ToyProject.PetCaringService.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/member")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/join")
    public String memberForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/memberJoinForm";
    }

    @PostMapping(value = "/join")
    public String joinMember(@Valid MemberDto memberDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "member/memberJoinForm";
        }
        try {
            Member member = Member.createMember(memberDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberJoinForm";
        }
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인하세요");
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/success")
    public String loginSuccess(Authentication auth) {
        System.out.println("Authentication 안에 해당 로그인 사용자 정보 담겨 있음");
        System.out.println("Member Login Success");
        return "index";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        System.out.println("Member Logout Success");
        return "index";
    }
}
