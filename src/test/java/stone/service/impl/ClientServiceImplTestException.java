package stone.service.impl;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Client;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.ClientCrudRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTestException {
    @Mock
    private ClientCrudRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;
    private Client client = Client.builder().withName("name").withEmail("mail@gmail.com").build();


    @After
    public void resetMock() {
        reset(clientRepository);
    }
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnExceptionWithIdLessThenZero() {
        when(clientRepository.size()).thenReturn(9);
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("Client dont found"));
        clientService .deleteById(-2L);
    }
    @Test
    public void shouldReturnExceptionWithIdMoreSizeRepository() {
        when(clientRepository.size()).thenReturn(9);
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("Client dont found"));
        clientService.deleteById(11L);
    }

    @Test
    public void shouldReturnExceptionWithNull() {
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("Arrgument = Null"));
        clientService.register(null);
    }

}