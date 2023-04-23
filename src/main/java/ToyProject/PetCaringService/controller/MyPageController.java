package ToyProject.PetCaringService.controller;

import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.repository.MemberRepository;
import ToyProject.PetCaringService.service.MemberService;
import ToyProject.PetCaringService.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping
    public String myPage(Authentication auth, Model model) {
        Member member = getMember(auth);
        model.addAttribute("member", member);
        return "member/myPage";
    }

    private Member getMember(Authentication auth) {
        String name = auth.getName();
        return memberRepository.findByEmail(name);
    }
}
