package org.zerock.mreview.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
    //로그인화면
    @GetMapping("/login")
    public void login(){}

    // 로그아웃화면. 로그인한 경우에만 접근가능
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/logout")
    public void logout(){}
}
