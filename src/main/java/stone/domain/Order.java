package stone.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Order {
    private Long id;
    private final String email;
    private final Necklace order;

    public Order(String email, Necklace necklace) {
        this.email = email;
        this.order = new Necklace(necklace.getNecklaces(), necklace.getCost(), necklace.getWeight());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Necklace getOrder() {
        return order;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order1 = (Order) o;
        return email.equals(order1.email) &&
                order.equals(order1.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, order);
    }
}
