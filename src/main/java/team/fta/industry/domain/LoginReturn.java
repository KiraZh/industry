package team.fta.industry.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginReturn {
    @JSONField(name = "code")
    private int code;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "sessionKey")
    private String sessionKey = "";

}