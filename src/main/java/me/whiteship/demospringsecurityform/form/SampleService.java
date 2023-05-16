package me.whiteship.demospringsecurityform.form;

import me.whiteship.demospringsecurityform.account.Account;
import me.whiteship.demospringsecurityform.account.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {
    public void dashboard() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 사용자에 대한 권한
//        Object credentials = authentication.getCredentials();
//        boolean authenticated = authentication.isAuthenticated();

//        Account account = AccountContext.getAccount();
//        System.out.println("===============");
//        System.out.println(account.getUsername());

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // principal 이 object 타입이라 변환해야함
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("===============");
        System.out.println(authentication);
        System.out.println(userDetails.getUsername());

    }
}
