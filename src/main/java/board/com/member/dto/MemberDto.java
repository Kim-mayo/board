package board.com.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemberDto {

    private String id;
    private String password;
    private String name;
    private String email;

    public MemberDto() {
    }

    public MemberDto(board.com.member.entity.Member member) {
        this.email = member.getEmail();
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
    }
}
