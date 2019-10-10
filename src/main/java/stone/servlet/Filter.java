package stone.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Stone;
import stone.enums.Transparency;
import stone.servlet.market.OrderForm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Component
public class Filter {
    private ArrayList<Stone> stones1 = new ArrayList<>();
    private Integer param1;
    private Integer param2;
    private final OrderForm orderForm;
    private ArrayList<Stone> stones ;

    @Autowired
    public Filter(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public void filter(HttpServletRequest req) {

        req.setAttribute("transparency", Transparency.values());
        if (req.getParameter("param1") != null && req.getParameter("param2") != null) {

            saveDate(req);
            stones = orderForm.getStones();
            for (Stone stone : stones) {
                if (stone.getTransparency().getRankingPosition() >= param1 && stone.getTransparency().getRankingPosition() <= param2) {
                    stones1.add(stone);
                }
            }
            req.setAttribute("stonesFilter", stones1);
        }
    }
    private void saveDate(HttpServletRequest req) {
        if (req.getParameter("param1") != null && req.getParameter("param2") != null) {
            param1 = Integer.valueOf(req.getParameter("param1"));
            param2 = Integer.valueOf(req.getParameter("param2"));
            if (param1 > param2) {
                Integer temp = param1;
                param1 = param2;
                param2 = temp;
            }
        }
    }

}
