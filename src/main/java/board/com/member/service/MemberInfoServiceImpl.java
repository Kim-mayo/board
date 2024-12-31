package board.com.member.service;

import board.com.member.dto.MemberDto;
import board.com.member.entity.Member;
import board.com.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberRepository memberRepository;

    private final EntityManager em;

    @Override
    public Member retrieveMember(String loginId) {
        Optional<Member> findMember = memberRepository.findById(loginId);
        return findMember.orElse(null);
    }

    @Override
    public List<Member> retrieveMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member insertMember(Member member) {
        duplicationCheck(member);
        memberRepository.save(member);
        return member;
    }

    private void duplicationCheck(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 ID 입니다");
                });
    }

    @Override
    public Member updateMember(Member member) {
        Member updateMember = em.find(Member.class, member.getId());
        updateMember.setName(member.getName());
        updateMember.setEmail(member.getEmail());
        updateMember.setPassword(member.getPassword());
        return updateMember;
    }

    @Override
    public void deleteMember(String loginId) {
        memberRepository.deleteById(loginId);
    }
}
