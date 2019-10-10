package stone.repository.impl;

import stone.domain.Client;
import org.springframework.stereotype.Repository;
import stone.repository.contract.ClientCrudRepository;
import stone.service.PasswordInCode;
import stone.service.ValidateService;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
@Repository
public class ClientCrudRepositoryImpl implements ClientCrudRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, Client> idToClient = new HashMap<>();
    private static Map<String, List<Client>> bySurName = Collections.emptyMap();
    private static Map<String, List<Client>> byEmail = Collections.emptyMap();

    {
        Client client = Client.builder()
                .withId(1L)
                .withEmail("Max@gmail.com")
                .withPassword(PasswordInCode.passwordEncoded("Qwert1234567"))
                .withPhone("3698744444")
                .withName("Max")
                .withSurName("Kru")
                .build();
        save(client);

    }
    @Override
    public Client save(Client client) {
        Long id = client.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            client.setId(id);
        }
        idToClient.put(id, client);
        updateIndices();
        return idToClient.get(id);
    }

    @Override
    public void update(Client client) {
        save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(idToClient.get(id));
    }

    @Override
    public Client deleteById(Long id) {
        Client client = idToClient.remove(id);
        updateIndices();
        return client;
    }

    private void updateIndices() {
        bySurName = idToClient.values().stream().collect(Collectors.groupingBy(Client::getSurName));
        byEmail = idToClient.values().stream().collect(Collectors.groupingBy(Client::getEmail));

    }

    @Override
    public Integer size() {
        return idToClient.size();
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        ValidateService.notNull(email);
        for (Long aLong : idToClient.keySet()) {
            if (idToClient.get(aLong).getEmail().equals(email)) {
                return Optional.ofNullable(idToClient.get(aLong));
            }
        }
        return Optional.empty();

    }
}
