package cs.borrowdonga.dto.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteRequestDto {

    private String studentNumber;

    @Builder
    public DeleteRequestDto(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
