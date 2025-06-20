package org.zerock.mreview.security.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User implements OAuth2User {
  private String email;// id역할
  private String password;
  private String name;
  private boolean fromSocial;
  private Map<String, Object> attr;

  public ClubAuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
    this(username, password, fromSocial, authorities);
    this.attr = attr;
  }

  // 생성자 오버로딩
  public ClubAuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.email = username;
    this.password = password;
    this.fromSocial = fromSocial;
  }
  
  @Override
  public Map<String, Object> getAttributes() {
      return this.attr;
  }
}
