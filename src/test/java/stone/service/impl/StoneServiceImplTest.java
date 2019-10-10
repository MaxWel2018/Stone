package stone.service.impl;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Gemstone;
import stone.domain.Stone;
import stone.repository.contract.StoneCrudRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoneServiceImplTest {
    @Mock
    private StoneCrudRepository stoneCrudRepository;

    @InjectMocks
    private StoneServiceImpl stoneService;

    Gemstone gemstone = Gemstone.newBuilder().withPrice(600).build();
    @After
    public void resetMock() {
        Mockito.reset(stoneCrudRepository);
    }

    @Test
    public void shuoldReturnClientSave() {
        when(stoneCrudRepository.save(any(Stone.class))).thenReturn(gemstone);
        Stone stone = stoneService.register(gemstone);
        assertNotNull(stone);
    }
    @Test
    public void shuoldReturnClientDeleteById() {
        when(stoneCrudRepository.deleteById(any(Long.class))).thenReturn(gemstone);
        when(stoneCrudRepository.size()).thenReturn(15);
        Stone client1 = stoneService.deleteById(1L);
        assertNotNull(gemstone);
    }
    @Test
    public void shuoldReturnClientFindById() {
        when(stoneCrudRepository.findById(any(Long.class))).thenReturn(Optional.of(gemstone));
        Optional<Stone> client1 = stoneService.findById(1L);
        assertNotNull(gemstone);
    }

}