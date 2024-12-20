package com.agora.api;

import com.agora.model.AppUser;
import com.agora.model.ResCode;
import com.agora.model.ResponseParam;
import com.agora.model.TokenInfo;
import com.agora.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/app/chat/user/register")
    public ResponseEntity register(@RequestBody @Valid AppUser appUser) {
        appUserService.registerUser(appUser);

        ResponseParam responseParam = new ResponseParam();
        responseParam.setCode(ResCode.RES_OK.getCode());
        return ResponseEntity.ok(responseParam);
    }

    @PostMapping("/app/chat/user/login")
    public ResponseEntity login(@RequestBody @Valid AppUser appUser) {
        TokenInfo token = appUserService.loginUser(appUser);

        ResponseParam responseParam = new ResponseParam();
        responseParam.setAccessToken(token.getToken());
        responseParam.setExpireTimestamp(token.getExpireTimestamp());
        responseParam.setChatUserName(token.getChatUserName());
        responseParam.setAgoraUid(token.getAgoraUid());
        return ResponseEntity.ok(responseParam);
    }
}
