package stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Order;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.OrderCrudRepository;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderCrudRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderCrudRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Order dont found")));
    }

    @Override
    public Order deleteById(Long id) {
        if (id < 0 && id<orderRepository.size()) {
            throw new dontCorrectArgumentRuntimeException("Order don't found");
        }
        return orderRepository.deleteById(id);
    }
}
