package org.zerock.mreview.security.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.mreview.security.dto.ClubAuthMemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClubLoginSuccessHandler implements AuthenticationSuccessHandler{
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

    private PasswordEncoder passwordEncoder;

    public ClubLoginSuccessHandler(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
            ClubAuthMemberDTO authMember = (ClubAuthMemberDTO)authentication.getPrincipal();

            boolean fromSocial = authMember.isFromSocial(); // 소셜로그인 여부.

            log.info("Need Modify Member?" + fromSocial);
    
            // matches()는 사용자가 입력한 비밀번호와 테이블에 암호화되어 있는 비밀번호를 비교해서 같으면 true.
            // 1111이 사용자가 입력한 비밀번호라고 가정
            // 로그인 후 사용자정보를 수정할 때 비밀번호가 같은지 비교할 때 필요.
            boolean passwordResult = passwordEncoder.matches("1111", authMember.getPassword());
    
           if(fromSocial && passwordResult) {
               redirectStratgy.sendRedirect(request, response, "/member/modify?from=social"); // 수정페이지로 이동
           }

                
    }
    
}
