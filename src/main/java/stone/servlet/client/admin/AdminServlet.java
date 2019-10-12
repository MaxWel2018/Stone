package stone.servlet.client.admin;

import org.springframework.beans.factory.annotation.Autowired;
import stone.service.AdminService;
import stone.servlet.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends AbstractServlet {
    @Autowired
    private AdminService service;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (service.checkAdmin(req)) {
            req.getRequestDispatcher("/views/admin.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/views/errorAccess.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
