package stone.repository.contract;

import stone.domain.Stone;

import java.util.Map;

public interface StoneCrudRepository extends CrudRepository<Stone> {
    Integer size();
    Map<Long, Stone> getAll();

    Stone get(Long id);

}
