package stone.repository.contract;

import stone.domain.Client;

import java.util.Optional;

public interface ClientCrudRepository extends CrudRepository<Client> {
    Integer size();

    public Optional<Client> findByEmail(String email);
}
