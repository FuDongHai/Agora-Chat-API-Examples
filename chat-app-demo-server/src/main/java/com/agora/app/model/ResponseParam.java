package com.agora.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseParam {
    private ResCode code = ResCode.RES_OK;
    private int statusCode = ResCode.RES_OK.getCode();
    private String appkey;
    private String channel;
    private String userId;
    private String accessToken;
    private String token;
    private String errorInfo;
    private Long expireTimestamp;
    private String chatUserName;
    private String chatUserNickname;
    private String avatarUrl;
    private String agoraUid;
}
