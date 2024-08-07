package exam01;

import config.AppCtx;
import mappers.member.MemberMapper;
import member.entities.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
@Transactional
public class Ex03 {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void test1() {
        long total = memberMapper.getTotal();
        System.out.println(total);
    }

    @Test // 여기서 proxy의 공통기능이 뭐야?
    void test2() {
        Member member = Member.builder()
                .email("user99@test.org")
                .password("1111")
                .userName("Tom")
                .build();

        int result = memberMapper.register(member);

        Member member2 = memberMapper.get(member.getEmail());
        System.out.println(member2);

        int exists = memberMapper.exists(member.getEmail());
        System.out.println(exists);
    }
}


