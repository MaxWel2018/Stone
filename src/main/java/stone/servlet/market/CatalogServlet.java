package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import stone.repository.StoneCrudRepository;
import stone.servlet.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends AbstractServlet {

    @Autowired
    private StoneCrudRepository stoneRepository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("stones", stoneRepository.getAll());
        req.getRequestDispatcher("/views/catalog.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] selectedItem = req.getParameterValues("selected");
        HttpSession session = req.getSession();
        session.setAttribute("selectedItem", selectedItem);//id items


        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/order"));
        //TODO перенаправить на корзину с покупками + юзверя данные записать

    }
}
