package stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Stone;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.StoneCrudRepository;

import java.util.Optional;

@Service
public class StoneServiceImpl implements StoneService {

    private final StoneCrudRepository stoneRepository;

    @Autowired
    public StoneServiceImpl(StoneCrudRepository stoneRepository) {
        this.stoneRepository = stoneRepository;
    }

    @Override
    public Optional<Stone> findById(Long id) {
        return Optional.ofNullable(stoneRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Stone dont found")));
    }
    @Override
    public Stone deleteById(Long id) {
        return stoneRepository.deleteById(id);
    }


}
