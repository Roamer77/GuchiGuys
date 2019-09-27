package hello.security;


import hello.controllers.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RestController
public class CheckAuthorization {
    private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    @GetMapping("/check")
    private Response checkAuthorization() {

        Collection<? extends GrantedAuthority> listOfRoles = authentication.getAuthorities();

        ArrayList<String> res = new ArrayList<>();
        listOfRoles.forEach(s -> res.add(((GrantedAuthority) s).getAuthority()));
        listOfRoles.forEach(System.out::println);
        return new Response("Done", res);
    }


}
