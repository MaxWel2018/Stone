package stone.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Client;
import stone.repository.ClientCrudRepository;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
     @Mock
     ClientCrudRepository clientRepository;

    @InjectMocks
    ClientService clientService;

    @After
    public void resetMock() {
       reset(clientRepository);
    }

    @Test
    public void shuoldReturnStudent() {
        Client client = Client.builder().withName("name").withEmail("mail@gmail.com").build();
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        Client client1 = clientService.register(client);
        assertNotNull(client);
    }



}