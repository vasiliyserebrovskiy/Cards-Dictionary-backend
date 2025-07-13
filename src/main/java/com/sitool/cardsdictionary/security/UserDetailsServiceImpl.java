package com.sitool.cardsdictionary.security;

import com.sitool.cardsdictionary.accounting.model.User;
import com.sitool.cardsdictionary.accounting.dao.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Collection<String> roles = userAccount.getRoles().stream()
                .map(r -> "ROLE_" + r.getRoleName())
                .toList();
        return new org.springframework.security.core.userdetails.User(username, userAccount.getPassword(), AuthorityUtils.createAuthorityList(roles));
    }
}
