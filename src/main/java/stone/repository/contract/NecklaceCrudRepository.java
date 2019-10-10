package stone.repository.contract;

import stone.domain.Necklace;

public interface NecklaceCrudRepository extends CrudRepository<Necklace> {
    Integer size();


}
