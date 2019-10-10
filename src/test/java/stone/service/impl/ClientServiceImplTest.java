package stone.service.impl;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Client;
import stone.repository.contract.ClientCrudRepository;
import stone.service.PasswordInCode;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
     @Mock
     private ClientCrudRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;
    private Client client = Client.builder().withName("name").withEmail("mail@gmail.com").withPassword(PasswordInCode.passwordEncoded("Qwert1234567")).build();


    @After
    public void resetMock() {
       reset(clientRepository);
    }

    @Test
    public void shuoldReturnClientSave() {
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        Client client1 = clientService.register(client);
        assertNotNull(client);
    }
    @Test
    public void shuoldReturnClientDeleteById() {
        when(clientRepository.deleteById(any(Long.class))).thenReturn(client);
        when(clientRepository.size()).thenReturn(15);
        Client client1 = clientService.deleteById(1L);
        assertNotNull(client);
    }
    @Test
    public void shuoldReturnClientFindById() {
        when(clientRepository.findById(any(Long.class))).thenReturn(Optional.of(client));
        Optional<Client> client1 = clientService.findById(1L);
        assertNotNull(client);
    }
    @Test
    public void shuoldReturnClientFindByEmail() {
        when(clientRepository.findByEmail(any(String.class))).thenReturn(Optional.of(client));
        Optional<Client> client1 = clientService.findByEmail("mail@gmail.com");
        assertNotNull(client);
    }

    @Test
    public void shuoldReturnClientLogin() {
        when(clientRepository.findByEmail(any(String.class))).thenReturn(Optional.of(client));
        clientService.login(client.getEmail(), "Qwert1234567");

    }






}