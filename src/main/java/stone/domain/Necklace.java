package stone.domain;

import java.util.ArrayList;
import java.util.List;

public class Necklace {
    private Long id;
    private List<Stone> necklaces = new ArrayList<>();


    public Necklace(List<Stone> necklaces) {
        this.necklaces = necklaces;
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
}
