package stone.repository;


import org.springframework.stereotype.Component;
import stone.domain.Order;
public interface OrderCrudRepository extends CrudRepository<Order> {

    Integer size();
}
