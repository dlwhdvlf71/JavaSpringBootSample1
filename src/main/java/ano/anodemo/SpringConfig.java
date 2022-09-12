package ano.anodemo;

import ano.anodemo.repository.JpaMemberRepository;
import ano.anodemo.repository.MemberRepository;
import ano.anodemo.repository.MemoryMemberRepository;
import ano.anodemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
