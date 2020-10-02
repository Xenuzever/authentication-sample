package jp.bootware.authesample.infrastructure.service;

import jp.bootware.authesample.infrastructure.dto.CustomUserDetails;
import jp.bootware.authesample.infrastructure.model.User;
import jp.bootware.authesample.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: TCMALTUNKAN - MEHMET ANIL ALTUNKAN
 * @Date: 30.12.2019:09:07, Pzt
 **/
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(s)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email " + s));
    return new CustomUserDetails(user);
  }
}
