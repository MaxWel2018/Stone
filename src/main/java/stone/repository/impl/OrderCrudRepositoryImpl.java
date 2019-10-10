package stone.repository.impl;

import org.springframework.stereotype.Repository;
import stone.domain.Order;
import stone.repository.contract.OrderCrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class OrderCrudRepositoryImpl implements OrderCrudRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, Order> idToOrder = new HashMap<>();

    @Override
    public Order save(Order order) {
        Long id = order.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            order.setId(id);
        }
        idToOrder.put(id, order);
        updateIndices();
        return idToOrder.get(id);
    }

    @Override
    public void update(Order order) {
        save(order);

    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(idToOrder.get(id));
    }
    @Override
    public Order deleteById(Long id) {
        Order order = idToOrder.remove(id);
        updateIndices();
        return order;
    }

    @Override
    public Integer size() {
        return idToOrder.size();
    }

    private void updateIndices() {
    }
}
