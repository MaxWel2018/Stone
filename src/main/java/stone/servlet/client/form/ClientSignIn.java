package stone.servlet.client.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Client;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.service.contract.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class ClientSignIn {

    private ClientService clientService;

    private String email;
    private String password;
    private String name;
    private String surName;


    @Autowired
    public ClientSignIn(ClientService clientService) {
        this.clientService = clientService;
    }

    public void checkDate(HttpServletRequest req) {
        saveDate(req);
        clientService.login(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("name", name);
        session.setAttribute("surName", surName);

    }

    private void saveDate(HttpServletRequest req) {
        email = req.getParameter("Email");
        password = req.getParameter("password");
        Optional<Client> client = Optional.ofNullable(clientService.
                findByEmail(email).orElseThrow(
                () -> new dontCorrectArgumentRuntimeException("client dont found")));
        name = client.map(Client::getName).orElse(name = "");
        surName = client.map(Client::getSurName).orElse(surName = "");
        ;

    }
}
