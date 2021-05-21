package cs.borrowdonga.dto.member;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JoinRequestDto {

    private String name;
    private String department;
    private String studentNumber;
    private String password;
    private String email;
    private String phoneNumber;

    @Builder
    public JoinRequestDto(String name, String department, String studentNumber, String password, String email, String phoneNumber) {
        this.name = name;
        this.department = department;
        this.studentNumber = studentNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
