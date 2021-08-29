package hello.springboard.controller;

import hello.springboard.model.Member;
import hello.springboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/new")
    public String joinForm(){
        return "member/joinMemberForm";
    }

    @PostMapping("/member/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(form.getPassword()));
        member.setName(form.getName());
        member.setRole(0);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/member")
    public String list(Model model){
        List<Member> members = memberService.memberlist();
        model.addAttribute("members", members);
        return "member/memberList";
    }

    @GetMapping("/member/login")
    public String login(){
        return "member/memberLogin";
    }
}
