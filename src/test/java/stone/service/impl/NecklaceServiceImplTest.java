package stone.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Necklace;
import stone.repository.contract.NecklaceCrudRepository;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NecklaceServiceImplTest {

    @Mock
    private NecklaceCrudRepository necklaceCrudRepository;

    @InjectMocks
    private NecklaceServiceImpl necklaceService;

    private  Necklace necklace = new Necklace();

    @Test
    public void shuoldNeclaceClientSave() {
        when(necklaceCrudRepository.save(any(Necklace.class))).thenReturn(necklace);
        Necklace necklace1 = necklaceService.register(necklace);
        assertNotNull(necklace1);

    }

    @Test
    public void shuoldReturnNecklaceDeleteById() {
        when(necklaceCrudRepository.deleteById(anyLong())).thenReturn(necklace);
        when(necklaceCrudRepository.size()).thenReturn(15);
        Necklace  necklace1 = necklaceService.deleteById(1L);
        assertNotNull(necklace1);
    }
    @Test
    public void shuoldReturnNecklaceFindById() {
        when(necklaceCrudRepository.findById(anyLong())).thenReturn(Optional.of(necklace));
        Optional<Necklace> necklace = necklaceService.findById(1L);
        assertNotNull(necklace);
    }

}