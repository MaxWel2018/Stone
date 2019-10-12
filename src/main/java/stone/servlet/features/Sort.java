package stone.servlet.features;

import edu.emory.mathcs.backport.java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Stone;
import stone.servlet.market.OrderForm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Sort {
    private final OrderForm orderForm;
    private ArrayList<Stone> stones ;

    @Autowired
    public Sort(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public void sort(HttpServletRequest req) {
        stones = orderForm.getStones();
       Collections.sort(stones);
        req.setAttribute("stonesSort", stones);
    }
}
