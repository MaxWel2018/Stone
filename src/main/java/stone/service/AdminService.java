package stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stone.domain.Gemstone;
import stone.domain.User;
import stone.enums.*;
import stone.service.contract.UserService;

import javax.servlet.http.HttpServletRequest;

@Service
public class AdminService {
    private final UserService userService;

    @Autowired
    public AdminService(UserService userCrudRepository) {
        this.userService = userCrudRepository;
    }

    public Boolean checkAdmin(HttpServletRequest req) {
        String email = (String) req.getSession().getAttribute("email");
        Boolean isAdmin = userService.findByRole(AccessLevel.ADMIN, email);
        if (isAdmin) {
            return true;
        } else {
            return false;
        }
    }

    public void setAtribute(HttpServletRequest req) {
        req.setAttribute("color", Color.values());
        req.setAttribute("transparency", Transparency.values());
        req.setAttribute("typeGem", GemstoneType.values());
        req.setAttribute("typeSem", SemipreciouStoneType.values());

    }


}

