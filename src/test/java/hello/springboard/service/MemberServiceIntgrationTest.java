package hello.springboard.service;

import hello.springboard.model.Member;
import hello.springboard.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceIntgrationTest {
//    @Autowired
//    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        for(int i=0; i<100; i++) {
            Member member = new Member();
            member.setId("id" + i);
            member.setPassword("pw" + i);
            member.setName("name" + i);

            if(i <= 80) {
                member.setRole(0);
            }else if(i <= 90) {
                member.setRole(1);
            }else {
                member.setRole(2);
            }
            memberRepository.save(member);
        }

    }
    @Test
    public void 중복회원예외(){
//        //given
//        Member member1 = new Member();
//        member1.setName("hello2");
//        Member member2 = new Member();
//        member2.setName("hello3");
//
//        //when
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        try{
////            memberService.join(member2);
////            fail();
////        }catch(IllegalStateException e){
////            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////        }
//
//
//        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}
