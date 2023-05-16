package me.whiteship.demospringsecurityform.account;

import ch.qos.logback.core.util.StatusPrinter;
import org.aspectj.bridge.MessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class AccountControllerTest {

    //@Autowired
    MockMvc mockMvc;

    //@Test
    public void index_anonymous() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
   }
    //@Test
    //@WithAnonymousUser
    public void index_anonymous2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

   //@Test
   public void index_user() throws Exception{
       mockMvc.perform(MockMvcRequestBuilders.get("/")
               .with(SecurityMockMvcRequestPostProcessors.user("sg").roles("USER")))
               .andDo(MockMvcResultHandlers.print())
               .andExpect(MockMvcResultMatchers.status().isOk());
   }


    //@Test
    //@WithMockUser(username = "sg", roles = "USER")
    public void index_user2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
               .andDo(MockMvcResultHandlers.print())
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //@Test
    //@WithUser
    public void index_user3() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //@Test
    public void admin_user() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin")
                .with(SecurityMockMvcRequestPostProcessors.user("sg").roles("USER")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    //@Test
    //@WithMockUser(username = "sg", roles = "ADMIN")
    public void admin_admin() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //@Test
    public void login() throws Exception {
        mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin().user("sg").password("123"))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }


    //@Autowired
    AccountService accountService;


    //@Test
    /*public void login2() throws Exception {
        Account user = this.createUser();
        mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin().user(user.getUsername()).password("123"))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }*/

   /*
   private Account createUser(){
        Account account = new Account();
        account.setUsername("sg");
        account.setPassword("123");
        account.setRole("USER");
        return accountService.createNew(account);
    }
    */


    //@Test
    public void login3() throws Exception {
        String username = "sg";
        String password = "123";
       mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin().user(username).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    /*
    private Account createUser2(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("USER");
        return accountService.createNew(account);
    }
    */


}
