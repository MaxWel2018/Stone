package stone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Stone;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.StoneCrudRepository;
import stone.service.contract.StoneService;

import java.util.Optional;

import static stone.service.ValidateService.notNull;

@Service
public class StoneServiceImpl implements StoneService {

    private final StoneCrudRepository stoneRepository;

    @Autowired
    public StoneServiceImpl(StoneCrudRepository stoneRepository) {
        this.stoneRepository = stoneRepository;
    }

    @Override
    public Stone register(Stone stone) {
        notNull(stone);
        return stoneRepository.save(stone);
    }

    @Override
    public Optional<Stone> findById(Long id) {
        notNull(id);
        return Optional.ofNullable(stoneRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Stone dont found")));
    }

    @Override
    public Stone deleteById(Long id) {
        if (id < 0 || id>stoneRepository.size()) {
            throw new dontCorrectArgumentRuntimeException("Order don't found");
        }
        return stoneRepository.deleteById(id);
    }


}
