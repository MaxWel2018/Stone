package stone.service.contract;

import stone.domain.Stone;

import java.util.Optional;

public interface Service<T> {
    T register(T t);

    Optional<T> findById(Long id);

    T deleteById(Long id);
}
