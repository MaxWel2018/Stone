package stone.service;

import stone.domain.Client;

import java.util.Optional;

public interface ClientService  extends Service<Client>{

    Client register(Client client);

    Optional<Client> findByEmail(String email);

    Client login(String email, String password);

}
