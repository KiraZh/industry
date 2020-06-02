package team.fta.industry.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SignupReturn {
    private int code;
    private String message;
}
