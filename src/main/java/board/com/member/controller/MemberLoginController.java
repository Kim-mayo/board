package board.com.member.controller;

import board.com.member.entity.Member;
import board.com.member.service.MemberLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberLoginController {

    @Autowired
    private MemberLoginService memberLoginService;

    @PostMapping("/login")
    public Member login(HttpServletRequest request) {
        Member member = memberLoginService.login(request.getParameter("id"), request.getParameter("password"));
        if (member != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", member);
            session.setMaxInactiveInterval(60 * 30);
        }
        return member;

    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("loginMember");
    }


}
