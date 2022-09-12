package ano.anodemo.service;

import ano.anodemo.domain.Member;
import ano.anodemo.repository.MemberRepository;
import ano.anodemo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = service.join(member);

        // then
        Member findMember = service.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void 중복회원예외(){
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        // when
        service.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));

        assertEquals(e.getMessage(), "이미 존재하는 회원입니다");

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}