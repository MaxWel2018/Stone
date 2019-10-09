package stone.service;

import stone.domain.Stone;

import java.util.Optional;

public interface Service<T> {

    Optional<T> findById(Long id);

    T deleteById(Long id);
}
