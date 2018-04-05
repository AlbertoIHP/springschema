package back.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import back.security.model.Authority;
import back.security.model.User;;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) 
    {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getLastname(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate(),
                user.getPicture(),
                user.getIsActive(),
                user.getRole(),
                user.getDescription()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) 
    {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
