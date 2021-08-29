package hello.springboard.repository;

import hello.springboard.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Member login(Member member);

    Optional<Member> findBySeq(Long seq);
    Optional<Member> findById(String id);

    List<Member> findAll();
}
