package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
@Table(name = "USERS")
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    @Size(min = 3)
    private String password;

    private Boolean isEnabled;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isEnabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    //Срок действия аккаунта не истек
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //Аккаунт не заблокирован
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //Срок действия учетных данных не истек
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
