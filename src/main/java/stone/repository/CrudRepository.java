package stone.repository;

import java.util.Optional;

public interface CrudRepository<T> {

    T save(T t);

    void update(T t);

    Optional<T> findById(Long id);

    T deleteById(Long id);
}
