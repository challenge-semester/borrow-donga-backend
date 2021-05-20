package cs.borrowdonga.dto.member;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JoinRequestDto {

    private String name;
    private String department;
    private String studentNumber;

    @Builder
    public JoinRequestDto(String name, String department, String studentNumber) {
        this.name = name;
        this.department = department;
        this.studentNumber = studentNumber;
    }
}
