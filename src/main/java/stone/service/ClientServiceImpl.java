package stone.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Client;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.ClientCrudRepository;
import stone.repository.StoneCrudRepository;

import java.util.Optional;

import static stone.service.ValidateService.notNull;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger LOGGER = Logger.getLogger(ClientServiceImpl.class);
    private StoneCrudRepository stoneRepository;
    private ClientCrudRepository clientRepository;

    @Autowired
    public ClientServiceImpl(StoneCrudRepository stoneRepository, ClientCrudRepository clientRepository) {
        this.stoneRepository = stoneRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Client dont found")));
    }

    @Override
    public Client deleteById(Long id) {
        if (id < 0 && id < clientRepository.size()) {
            throw new dontCorrectArgumentRuntimeException("Client dont found");
        }
        return clientRepository.deleteById(id);
    }


    @Override
    public Client register(Client client) {
        notNull(client);
        return clientRepository.save(client);

    }



    @Override
    public Optional<Client> findByEmail(String email) {
        return Optional.ofNullable(clientRepository.findByEmail(email).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Client dont found")));
    }

    @Override
    public Client login(String email, String password) {
        Client client = findByEmail(email).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Login or password dont correct "));
        String clientPassword = client.getPassword();
        String encodePassword = PasswordInCode.passwordEncoded(password);

        if (clientPassword.equals(encodePassword)) {
            return client;
        }
        throw new dontCorrectArgumentRuntimeException("Login or password dont correct");
    }

}
