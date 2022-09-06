package ano.anodemo;

import ano.anodemo.repository.MemberRepository;
import ano.anodemo.repository.MemoryMemberRepository;
import ano.anodemo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
