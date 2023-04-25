package ToyProject.PetCaringService.controller;

import ToyProject.PetCaringService.domain.Member;
import ToyProject.PetCaringService.domain.Pet;
import ToyProject.PetCaringService.dto.PetDto;
import ToyProject.PetCaringService.repository.MemberRepository;
import ToyProject.PetCaringService.service.MyPageService;
import ToyProject.PetCaringService.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/mypage/pet")
@RequiredArgsConstructor
public class PetController {
    private final MyPageService myPageService;
    private final MemberRepository memberRepository;
    private final PetService petService;

//    @GetMapping
//    public String petList(Authentication auth, Model model) {
//        Member member = getMember(auth);
//        List<Pet> petList = member.getPetList();
//        model.addAttribute("petListEmpty", petList.isEmpty());
//        model.addAttribute("petList", petList);
//        return "member/myPage";
//    }

    @GetMapping(value = "/register")
    public String petRegisterForm(Authentication auth, Model model) {
        Member member = getMember(auth);
        model.addAttribute("member", member);
        model.addAttribute("petDto", new PetDto());
        return "pet/petRegisterForm";
    }

    @PostMapping(value = "/register")
    public String registerPet(@Valid PetDto petDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "pet/petRegisterForm";
        }
        Member member = new Member();
        try {
            Pet pet = Pet.registerPet(petDto, member);
            petService.savePet(pet);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "pet/petRegisterForm";
        }
        return "index";
    }

    private Member getMember(Authentication auth) {
        String name = auth.getName();
        return memberRepository.findByEmail(name);
    }
}
