package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import stone.domain.Necklace;
import stone.domain.Order;
import stone.service.contract.OrderService;
import stone.servlet.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderBasket")
public class BasketServlet extends AbstractServlet {
    @Autowired
    private CreatingNecklace creatingNecklace;

    @Autowired
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService.register(new Order((String) req.getSession().getAttribute("email"),creatingNecklace.addNecklace(req)));
        req.getRequestDispatcher("/views/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
