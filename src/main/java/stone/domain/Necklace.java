package stone.domain;

import java.util.ArrayList;
import java.util.List;

public class Necklace {
    private Long id;
    private List<Stone> necklaces = new ArrayList<>();
    private Integer cost;
    private Double weight;

    public Necklace(List<Stone> necklaces, Integer cost, Double weight) {
        this.necklaces = necklaces;
        this.cost = cost;
        this.weight = weight;
    }



    public Necklace() {
    }

    public List<Stone> getNecklaces() {
        return necklaces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNecklaces(List<Stone> necklaces) {
        this.necklaces = necklaces;
    }

    public Integer getCost() {
        return cost;
    }

    public Double getWeight() {
        return weight;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
