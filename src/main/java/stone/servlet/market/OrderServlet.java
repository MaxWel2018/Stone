package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import stone.servlet.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backet")
public class OrderServlet extends AbstractServlet {
    @Autowired
    private CreatingNecklace creatingNecklace;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        creatingNecklace.createNecklace(req);
        HttpSession session = req.getSession();
        session.removeAttribute("stones");
        req.getRequestDispatcher("/views/backet.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
