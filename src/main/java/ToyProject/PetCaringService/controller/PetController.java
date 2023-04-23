package ToyProject.PetCaringService.controller;

import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.repository.MemberRepository;
import ToyProject.PetCaringService.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/mypage/pet")
@RequiredArgsConstructor
public class PetController {
    private final MyPageService myPageService;
    private final MemberRepository memberRepository;

//    @GetMapping
//    public String petList(Authentication auth, Model model) {
//        Member member = getMember(auth);
//        List<Pet> petList = member.getPetList();
//        model.addAttribute("petListEmpty", petList.isEmpty());
//        model.addAttribute("petList", petList);
//        return "member/myPage";
//    }



    private Member getMember(Authentication auth) {
        String name = auth.getName();
        return memberRepository.findByEmail(name);
    }
}
