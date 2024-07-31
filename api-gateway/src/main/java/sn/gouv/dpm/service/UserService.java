package sn.gouv.dpm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sn.gouv.dpm.model.User;

public interface UserService extends UserDetailsService {
    User save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
