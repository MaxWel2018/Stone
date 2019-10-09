package stone.servlet.client;

import stone.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import stone.service.ClientService;
import stone.servlet.AbstractServlet;
import stone.servlet.client.form.ClientRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static stone.utility.RegexTemplate.*;

@WebServlet("/register")
public class RegisterClientServlet extends AbstractServlet {
    @Autowired
    ClientRegistration clientRegistration;
    @Autowired
    ClientService clientService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = clientRegistration.createClient(request);
        clientService.register(client);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/menu"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("REGEX_FOR_PASSWORD", REGEX_FOR_PASSWORD);
        request.setAttribute("REGEX_FOR_PHONE_NUMBER",REGEX_FOR_PHONE_NUMBER);
        request.setAttribute("REGEX_FOR_NAME",REGEX_FOR_NAME);
        request.setAttribute("REGEX_FOR_EMAIL", REGEX_FOR_EMAIL);
        request.getRequestDispatcher("/views/registrationClient.jsp").forward(request, response);

    }
}
