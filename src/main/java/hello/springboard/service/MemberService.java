package hello.springboard.service;

import hello.springboard.model.Member;
import hello.springboard.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        //같은 이름 중복 회원 X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        try{
            validateDuplicateMember(member);
        }catch(IllegalStateException e){

        }


        memberRepository.save(member);
        return member.getSeq();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public Optional<Member> findMember(Long memberId){
        return memberRepository.findBySeq(memberId);
    }

    public List<Member> memberlist(){
        return memberRepository.findAll();
    }
}
