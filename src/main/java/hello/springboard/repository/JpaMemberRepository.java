package hello.springboard.repository;

import hello.springboard.model.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member login(Member member) {
//        Member result = em.createQuery("select m from Member m where m.id=:name and m.password=:password", Member.class)
//                .setParameter("name", member.getId())
//                .setParameter("name", member.getPassword())
//                .getSingleResult();
//        return result;
        return null;
    }

    @Override
    public Optional<Member> findBySeq(Long seq) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> result = em.createQuery("select m from Member m where m.id=:id", Member.class)
                .setParameter("id", id)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
