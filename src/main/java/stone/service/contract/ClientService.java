package stone.service.contract;

import stone.domain.Client;

import java.util.Optional;

public interface ClientService  extends Service<Client>{


    Optional<Client> findByEmail(String email);

    Client login(String email, String password);

}
