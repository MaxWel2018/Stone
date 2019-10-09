package stone.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String email;
    private List<Necklace> order = new ArrayList<>();

    public Order( String email, List<Necklace> order) {
        this.email = email;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Necklace> getOrder() {
        return order;
    }

    public void setOrder(List<Necklace> order) {
        this.order = order;
    }
}
