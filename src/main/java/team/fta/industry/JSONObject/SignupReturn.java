package team.fta.industry.JSONObject;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SignupReturn {
    private int code;
    private String message;
}
