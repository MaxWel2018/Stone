package stone.service.impl;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stone.domain.Necklace;
import stone.domain.Order;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.OrderCrudRepository;
import stone.service.contract.OrderService;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
    @Mock
    private OrderCrudRepository orderCrudRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @After
    public void resetMock() {
        reset(orderCrudRepository);
    }

    private Order order = new Order("max@gmail.com", new Necklace());


    @Test
    public void shuoldReturnOrderSave() {
        when(orderCrudRepository.save(any(Order.class))).thenReturn(order);
        Order order2 = orderService.register(order);
        assertNotNull(order2);
    }
    @Test
    public void shuoldReturnOrderDeleteById() {
        when(orderCrudRepository.deleteById(any(Long.class))).thenReturn(order);
        when(orderCrudRepository.size()).thenReturn(15);
        Order order2 = orderService.deleteById(1L);
        assertNotNull(order2);
    }
    @Test
    public void shuoldReturnOrderFindById() {
        when(orderCrudRepository.findById(any(Long.class))).thenReturn(Optional.of(order));
        Optional<Order> order2 = orderService.findById(1L);
        assertNotNull(order2);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnExceptionWithIdLessThenZero() {
        when(orderCrudRepository.size()).thenReturn(9);
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("Order don't found"));
        orderService .deleteById(-2L);
    }




}