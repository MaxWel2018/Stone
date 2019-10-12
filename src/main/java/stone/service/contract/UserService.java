package stone.service.contract;

import stone.domain.User;
import stone.enums.AccessLevel;

import java.util.Optional;

public interface UserService extends Service<User>{


    Boolean findByRole(AccessLevel accessLevel, String email);

    Optional<User> findByEmail(String email);

    User login(String email, String password);

}
