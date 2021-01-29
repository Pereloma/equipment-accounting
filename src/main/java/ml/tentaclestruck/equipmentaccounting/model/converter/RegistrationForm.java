package ml.tentaclestruck.equipmentaccounting.model.converter;

import lombok.Data;
import ml.tentaclestruck.equipmentaccounting.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password));
    }
}
