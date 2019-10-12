package stone.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.User;
import stone.enums.AccessLevel;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.UserCrudRepository;
import stone.repository.contract.StoneCrudRepository;
import stone.service.ValidateService;
import stone.service.contract.UserService;
import stone.service.PasswordInCode;

import java.util.Optional;

import static stone.service.ValidateService.notNull;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private UserCrudRepository clientRepository;



    @Autowired
    public UserServiceImpl(UserCrudRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Boolean findByRole(AccessLevel accessLevel, String email) {
        ValidateService.notNull(accessLevel);
        ValidateService.notNull(email);
        return clientRepository.findByRole(accessLevel, email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("User dont found")));
    }

    @Override
    public User deleteById(Long id) {
        if (id < 0 || id > clientRepository.size()) {
            LOGGER.info("User dont found");
            throw new dontCorrectArgumentRuntimeException("User dont found");
        }
        return clientRepository.deleteById(id);
    }


    @Override
    public User register(User user) {
        notNull(user);
        return clientRepository.save(user);

    }


    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(clientRepository.findByEmail(email).orElseThrow(() -> new dontCorrectArgumentRuntimeException("User dont found")));
    }

    @Override
    public User login(String email, String password) {
        User user = findByEmail(email).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Login or password dont correct "));
        String clientPassword = user.getPassword();
        String encodePassword = PasswordInCode.passwordEncoded(password);

        if (clientPassword.equals(encodePassword)) {
            return user;
        }
        LOGGER.info("Login or password dont correct");
        throw new dontCorrectArgumentRuntimeException("Login or password dont correct");
    }

}
