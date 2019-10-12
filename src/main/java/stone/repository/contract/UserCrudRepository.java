package stone.repository.contract;

import stone.domain.User;
import stone.enums.AccessLevel;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User> {
    Boolean findByRole(AccessLevel accessLevel, String email);

    Integer size();

    public Optional<User> findByEmail(String email);
}
