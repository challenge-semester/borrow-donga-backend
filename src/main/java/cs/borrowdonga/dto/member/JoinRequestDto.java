package cs.borrowdonga.dto.member;

import cs.borrowdonga.domain.member.Member;
import cs.borrowdonga.domain.member.MemberRole;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class JoinRequestDto {

    private String username;
    private String department;
    private String studentNumber;
    private String password;
    private String email;
    private String phoneNumber;

    @Builder
    public JoinRequestDto(String username, String department, String studentNumber, String password, String email, String phoneNumber) {
        this.username = username;
        this.department = department;
        this.studentNumber = studentNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Member toEntity() {
        return Member.builder()
                .password(new BCryptPasswordEncoder().encode(password))
                .username(username)
                .email(email)
                .phoneNumber(phoneNumber)
                .department(department)
                .studentNumber(studentNumber)
                .role(MemberRole.USER)
                .build();
    }
}
