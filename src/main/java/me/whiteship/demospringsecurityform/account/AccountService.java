package me.whiteship.demospringsecurityform.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    // (T)ODO {noop}123 이러한 패턴 요구함
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account==null){
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

/*    public Account createNew(Account account) {
        account.setPassword("{noop}" + account.getPassword());
        return account;
    }*/

    public Account createNew(Account account) {
        account.encodePassword(passwordEncoder);
        return this.accountRepository.save(account);
    }
}
