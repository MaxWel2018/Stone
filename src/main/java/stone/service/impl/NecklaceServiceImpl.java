package stone.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Necklace;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.NecklaceCrudRepository;
import stone.service.contract.NecklaceService;

import java.util.Optional;

import static stone.service.ValidateService.notNull;

@Service
public class NecklaceServiceImpl implements NecklaceService {
private final NecklaceCrudRepository necklaceCrudRepository;
    private static final Logger LOGGER = Logger.getLogger(NecklaceServiceImpl.class);

    @Autowired
    public NecklaceServiceImpl(NecklaceCrudRepository necklaceCrudRepository) {
        this.necklaceCrudRepository = necklaceCrudRepository;
    }

    @Override
    public Necklace register(Necklace necklace) {
        notNull(necklace);
        return necklaceCrudRepository.save(necklace);
    }

    @Override
    public Optional<Necklace> findById(Long id) {
        return Optional.ofNullable(necklaceCrudRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Client dont found")));

    }

    @Override
    public Necklace deleteById(Long id) {
        if (id < 0 || id > necklaceCrudRepository.size()) {
            LOGGER.info("Client dont found");
            throw new dontCorrectArgumentRuntimeException("Client dont found");
        }
        return necklaceCrudRepository.deleteById(id);
    }
    }


