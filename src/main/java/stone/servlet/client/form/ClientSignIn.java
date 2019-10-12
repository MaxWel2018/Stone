package stone.servlet.client.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.User;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.service.contract.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class ClientSignIn {

    private UserService userService;

    private String email;
    private String password;
    private String name;
    private String surName;


    @Autowired
    public ClientSignIn(UserService userService) {
        this.userService = userService;
    }

    public void checkDate(HttpServletRequest req) {
        saveDate(req);
        userService.login(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("name", name);
        session.setAttribute("surName", surName);

    }

    private void saveDate(HttpServletRequest req) {
        email = req.getParameter("Email");
        password = req.getParameter("password");
        Optional<User> client = Optional.ofNullable(userService.
                findByEmail(email).orElseThrow(
                () -> new dontCorrectArgumentRuntimeException("client dont found")));
        name = client.map(User::getName).orElse(name = "");
        surName = client.map(User::getSurName).orElse(surName = "");
        ;

    }
}
