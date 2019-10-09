package stone.repository.impl;

import org.springframework.stereotype.Repository;
import stone.domain.Necklace;
import stone.repository.NecklaceCrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class NecklaceCrudRepositoryImpl implements NecklaceCrudRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, Necklace> idToNecklace = new HashMap<>();

    @Override
    public Necklace save(Necklace necklace) {
        Long id = necklace.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            necklace.setId(id);
        }
        idToNecklace.put(id, necklace);
        updateIndices();
        return idToNecklace.get(id);
    }

    private void updateIndices() {
    }

    @Override
    public void update(Necklace necklace) {
        save(necklace);
    }

    @Override
    public Optional<Necklace> findById(Long id) {
        return Optional.ofNullable(idToNecklace.get(id));
    }

    @Override
    public Necklace deleteById(Long id) {
        Necklace necklace = idToNecklace.remove(id);
        updateIndices();
        return necklace;
    }
}
