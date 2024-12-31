package board.com.member.entity;

import board.com.member.dto.MemberDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Member {

    @Id
    private String id;
    private String password;
    private String name;
    private String email;

    public Member() {

    }

    public Member(MemberDto memberDto) {
        this.id = memberDto.getId();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
        this.email = memberDto.getEmail();
    }
}
