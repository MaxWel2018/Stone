package stone.repository;

import stone.domain.Stone;

import java.util.Map;

public interface StoneCrudRepository extends CrudRepository<Stone> {

    Map<Long, Stone> getAll();

    Stone get(Long id);

}
