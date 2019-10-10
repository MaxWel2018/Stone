package stone.repository.contract;


import stone.domain.Order;
public interface OrderCrudRepository extends CrudRepository<Order> {

    Integer size();
}
