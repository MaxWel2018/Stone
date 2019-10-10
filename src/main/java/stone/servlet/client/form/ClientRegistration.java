package stone.servlet.client.form;

import org.springframework.beans.factory.annotation.Autowired;
import stone.domain.Client;
import org.springframework.stereotype.Component;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.exception.dontCorrectPasswordRuntimeEcxeption;
import stone.repository.contract.ClientCrudRepository;
import stone.service.ValidateService;
import stone.service.PasswordInCode;
import stone.utility.RegexTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class ClientRegistration {
    private String email;
    private String password;
    private String encodedPassword;
    private String confirmPassword;
    private String name;
    private String surName;
    private String phone;

    private final ClientCrudRepository clientRepository;

    @Autowired
    public ClientRegistration(ClientCrudRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Client createClient(HttpServletRequest req) {
        saveData(req);
        if (!password.equals(confirmPassword)) {
            throw new dontCorrectPasswordRuntimeEcxeption("Passwords do not match");
        }
        ValidateService.validate(email, RegexTemplate.REGEX_FOR_EMAIL);
        Optional<Client> client = clientRepository.findByEmail(email);
        if (client.isPresent()) {
            throw new dontCorrectArgumentRuntimeException("The User is already registered ");
        }
        ValidateService.validate(name, RegexTemplate.REGEX_FOR_NAME);

        ValidateService.validate(password, RegexTemplate.REGEX_FOR_PASSWORD);
        ValidateService.validate(phone, RegexTemplate.REGEX_FOR_PHONE_NUMBER);
        ValidateService.validate(surName, RegexTemplate.REGEX_FOR_NAME);
        encodedPassword = PasswordInCode.passwordEncoded(password);
        return Client.builder()
                .withName(name)
                .withEmail(email)
                .withPassword(encodedPassword)
                .withSurName(surName)
                .withPhone(phone)
                .build();

    }

    private void saveData(HttpServletRequest req) {
        name = req.getParameter("Name");
        surName = req.getParameter("SecondName");
        email = req.getParameter("email");
        password = req.getParameter("password");
        phone = req.getParameter("Phone");
        confirmPassword = req.getParameter("ConfirmPassword");

    }

}
