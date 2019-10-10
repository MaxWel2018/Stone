package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Necklace;
import stone.domain.Stone;
import stone.service.contract.NecklaceService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class CreatingNecklace {
    private final OrderForm orderForm;
    private Integer cost = 0;
    private Double weight = 0.0;
    private ArrayList<Stone> stones;
    private final NecklaceService necklaceService;


    @Autowired
    public CreatingNecklace(OrderForm orderForm, NecklaceService necklaceService) {
        this.orderForm = orderForm;
        this.necklaceService = necklaceService;
    }

    private void costing() {
        cost = 0;
        for (Stone stone : stones) {
            cost += stone.getPrice();
        }
    }
    private void setWeight() {
        weight = 0.0;
        for (Stone stone : stones) {
            weight += stone.getWeight();
        }
    }
    public Necklace addNecklace(HttpServletRequest req) {
        Necklace necklace = necklaceService.register(new Necklace(this.stones, cost, weight));
        req.setAttribute("necklace", necklace);
        return necklace;
    }

    public void createNecklace(HttpServletRequest req) {
        orderForm.saveDateWithCatalog(req);
        stones = orderForm.getStones();
        setWeight();
        costing();
        req.setAttribute("stones", stones);
        req.getSession().setAttribute("stones", stones);
        req.setAttribute("cost", cost);
        req.setAttribute("weight", weight);
        req.setAttribute("userEmail", orderForm.getUserEmail());
        req.setAttribute("userName", orderForm.getUserName());
        req.setAttribute("userSurName", orderForm.getUserSurName());


    }
}
