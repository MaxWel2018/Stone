package stone.repository.impl;

import stone.domain.User;
import org.springframework.stereotype.Repository;
import stone.enums.AccessLevel;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.UserCrudRepository;
import stone.service.PasswordInCode;
import stone.service.ValidateService;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class UserCrudRepositoryImpl implements UserCrudRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, User> idToClient = new HashMap<>();
    private static Map<String, List<User>> bySurName = Collections.emptyMap();
    private static Map<String, List<User>> byEmail = Collections.emptyMap();
    private static Map<AccessLevel, List<User>> byAccessLevel = Collections.emptyMap();
    {
        User user = User.builder()
                .withEmail("Max@gmail.com")
                .withPassword(PasswordInCode.passwordEncoded("Qwert1234567"))
                .withPhone("3698744444")
                .withName("Max")
                .withSurName("Kru")
                .build();
        save(user);
        User user1 = User.builder()
                .withEmail("Admin@gmail.com")
                .withPassword(PasswordInCode.passwordEncoded("Qwert1234567"))
                .withPhone("3698744444")
                .withName("Maksym")
                .withSurName("Krugovykh")
                .withAccessLevel(AccessLevel.ADMIN)
                .build();
        save(user1);
    }


    @Override
    public User save(User user) {
        Long id = user.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            user.setId(id);
        }
        idToClient.put(id, user);
        updateIndices();
        return idToClient.get(id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(idToClient.get(id));
    }

    @Override
    public Boolean findByRole(AccessLevel accessLevel, String email) {
        List<User> users = byAccessLevel.get(accessLevel);
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public User deleteById(Long id) {
        User user = idToClient.remove(id);
        updateIndices();
        return user;
    }


    @Override
    public Integer size() {
        return idToClient.size();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        ValidateService.notNull(email);
        for (Long aLong : idToClient.keySet()) {
            if (idToClient.get(aLong).getEmail().equals(email)) {
                return Optional.ofNullable(idToClient.get(aLong));
            }
        }
        return Optional.empty();

    }

    private void updateIndices() {
        bySurName = idToClient.values().stream().collect(Collectors.groupingBy(User::getSurName));
        byEmail = idToClient.values().stream().collect(Collectors.groupingBy(User::getEmail));
        byAccessLevel = idToClient.values().stream().collect(Collectors.groupingBy(User::getAccessLevel));
    }

}
