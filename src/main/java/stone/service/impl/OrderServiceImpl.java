package stone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Order;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.OrderCrudRepository;
import stone.service.contract.OrderService;

import java.util.Optional;

import static stone.service.ValidateService.notNull;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderCrudRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderCrudRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order register(Order client) {
        notNull(client);
       return orderRepository.save(client);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderRepository.findById(id).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Order dont found")));
    }

    @Override
    public Order deleteById(Long id) {
        if (id < 0 || id>orderRepository.size()) {
            throw new dontCorrectArgumentRuntimeException("Order don't found");
        }
        return orderRepository.deleteById(id);
    }
}
