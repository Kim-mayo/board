package board.com.member.service;

import board.com.member.entity.Member;
import board.com.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberLoginServiceImpl implements MemberLoginService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member login(String loginId, String password) {
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(loginId)
                .orElseThrow(() -> new IllegalStateException("해당 ID가 존재하지 않습니다.")));
        if(!password.equals(member.get().getPassword())){
           throw new IllegalStateException("비밀번호가 맞지 않습니다.");
        }
        return member.get();
    }
}
