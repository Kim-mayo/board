package board.com.member.service;

import board.com.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public interface MemberLoginService {

    Member login(String loginId, String password);

}
