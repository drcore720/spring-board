package hello.springboard.repository;

import hello.springboard.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    //DataSource인젝션이 필요
    @Autowired //생성자가 하나가 있으면 Autowired 생략 가능
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("seq");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", member.getId());
        parameters.put("password", member.getPassword());
        parameters.put("name", member.getName());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        member.setSeq(key.longValue());
        return member;
    }

    @Override
    public Member login(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findBySeq(Long seq) {
        List<Member> result = jdbcTemplate.query("select * from member where seq=?", memberRowMapper(), seq);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> result = jdbcTemplate.query("select * from member where id= ?", memberRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setSeq(rs.getLong("seq"));
            member.setId(rs.getString("id"));
            member.setPassword(rs.getString("password"));
            member.setName(rs.getString("name"));
            return member;
        };
//        lamda 통해서 변환
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Member member = new Member();
//                member.setId(rs.getLong("id"));
//                member.setName(rs.getString("name"));
//                return member;
//            }
//        }
    }
}
