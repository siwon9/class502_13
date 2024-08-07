package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor // final로 되거나 @NonNull 표시된 애들로 생성자 만들어준다.
public class JoinService {

    //@Autowired  의존성 주입을 해주는게 가장 중요한 역할이다.
    private final JoinValidator validator;

    //@Autowired
    @NonNull // 필수 요소임을 표시하는 것
    private MemberDao memberDao;

    // 의존 관계 - 없으면 객체 생성 X
    /*
    public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }
    */

    /*
    // 연관 관계 - 없어도 객체는 생성 된다.
    public void setValidator(JoinValidator validator) {
        this.validator = validator;
    }
    */
    public void process(RequestJoin form) {
        validator.check(form);  // joinService는 validator 객체, form 객체를 의존 -> 의존성

        // 데이터 영구 저장 - DAO(Data Access Object)
        Member member = Member.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .userName(form.getUserName())
                .regDt(LocalDateTime.now())
                .build();

        memberDao.register(member);
    }
}