package ano.anodemo.service;

import ano.anodemo.domain.Member;
import ano.anodemo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService service;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Spring2");

        // when
        Long saveId = service.join(member);

        // then
        Member findMember = service.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void 회원불러오기(){
        // given

        // when
        List<Member> members = service.findMembers();
        // then

    }

}
