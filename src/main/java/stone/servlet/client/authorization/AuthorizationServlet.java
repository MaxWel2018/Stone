package stone.servlet.client.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import stone.servlet.AbstractServlet;
import stone.servlet.client.form.ClientSignIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends AbstractServlet {

    @Autowired
    ClientSignIn clientSignIn;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clientSignIn.checkDate(req);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/catalog"));

    }
}
