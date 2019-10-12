package stone.servlet.client.admin;

import org.springframework.beans.factory.annotation.Autowired;
import stone.service.AdminService;
import stone.servlet.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStone")
public class AdminAddStoneServlet extends AbstractServlet {
    @Autowired
    private AdminService service;
    @Autowired
    private AddStoneForm addStoneForm;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (service.checkAdmin(req)) {
            service.setAtribute(req);
            req.getRequestDispatcher("/views/addStone.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/views/errorAccess.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addStoneForm.addStoneToRepository(req);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/catalog"));

    }

}
