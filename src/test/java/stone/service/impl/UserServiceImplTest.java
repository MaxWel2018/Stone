package stone.service.impl;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.User;
import stone.repository.contract.UserCrudRepository;
import stone.service.PasswordInCode;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserCrudRepository clientRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user = User.builder().withName("name").withEmail("mail@gmail.com").withPassword(PasswordInCode.passwordEncoded("Qwert1234567")).build();


    @After
    public void resetMock() {
        reset(clientRepository);
    }

    @Test
    public void shouldReturnClientSave() {
        when(clientRepository.save(any(User.class))).thenReturn(user);
        User user1 = userService.register(user);
        assertNotNull(user);
    }

    @Test
    public void shouldReturnClientDeleteById() {
        when(clientRepository.deleteById(anyLong())).thenReturn(user);
        when(clientRepository.size()).thenReturn(15);
        User user1 = userService.deleteById(1L);
        assertNotNull(user);
    }

    @Test
    public void shouldReturnClientFindById() {
        when(clientRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        Optional<User> client1 = userService.findById(1L);
        assertNotNull(user);
    }

    @Test
    public void shouldReturnClientFindByEmail() {
        when(clientRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        Optional<User> client1 = userService.findByEmail("mail@gmail.com");
        assertNotNull(user);
    }

    @Test
    public void shouldReturnClientLogin() {
        when(clientRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        userService.login(user.getEmail(), "Qwert1234567");

    }
}