package stone.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import stone.domain.Order;
import stone.domain.Stone;
import stone.enums.Transparency;
import stone.servlet.market.OrderForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/filter")
public class FilterSrvlet extends AbstractServlet {
    @Autowired
    private Filter filter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        filter.filter(req);
        req.getRequestDispatcher("/views/filter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
