package board.com.member.service;
import board.com.member.entity.Member;

import java.util.List;

public interface MemberInfoService {

    Member retrieveMember(String loginId);

    List<Member> retrieveMembers();

    Member insertMember(Member member);

    Member updateMember(Member member);

    void deleteMember(String loginId);

}
