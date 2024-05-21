package exam01;

import member.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Ex01 {

    @Test
    void test1() {
        Member member = new Member();
        member.setUserId("user01");
        member.setUserNm("suer01");
        member.setEmail("user01@test.org");
        member.setRegDt(LocalDateTime.now());
    }

    @Test
    void test2() {
        Member member1 = new Member();
        member1.setUserId("user01");
        member1.setUserNm("suer01");
        member1.setEmail("user01@test.org");
        member1.setRegDt(LocalDateTime.now());

        Member member2 = new Member();
        member2.setUserId("user01");
        member2.setUserNm("suer01");
        member2.setEmail("user01@test.org");
        member2.setRegDt(LocalDateTime.now());
        System.out.println(member1.equals(member2));
        System.out.println(member1.hashCode());
        System.out.println(member1.hashCode());
    }
}



