package ano.anodemo.repository;

import ano.anodemo.domain.Member;
import ano.anodemo.repository.MemberRepository;
import ano.anodemo.repository.MemoryMemberRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // AfterEach는 각각 Test 함수가 끝날때 마다 도는 로직을 넣는다.
    // 공용 변수나 클리어 해줘야 하는 경우 사용된다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // 1번
//        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName()
    {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> results = repository.findAll();

        Assertions.assertEquals(results.size(), 2);
    }

}
