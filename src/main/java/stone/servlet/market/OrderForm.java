package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Stone;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.NecklaceCrudRepository;
import stone.repository.OrderCrudRepository;
import stone.repository.StoneCrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Component
public class OrderForm {
    private String[] selectedItems;
    private String userEmail;
    private String userName;
    private String userSurName;
    private Integer totalCost = 0   ;
    private ArrayList<Stone> stones = new ArrayList<>();
    private final StoneCrudRepository stoneRepository;
    private final OrderCrudRepository orderRepository;
    private final NecklaceCrudRepository necklaceRepository;

    @Autowired
    public OrderForm(StoneCrudRepository stoneRepository, OrderCrudRepository orderRepository, NecklaceCrudRepository necklaceRepository) {
        this.stoneRepository = stoneRepository;
        this.orderRepository = orderRepository;
        this.necklaceRepository = necklaceRepository;
    }

    public void setAttribute(HttpServletRequest req) {
        saveData(req);
        createStoneForNeck();
        req.setAttribute("stones", stones);
        req.setAttribute("totalCost", totalCost);
        req.setAttribute("userEmail", userEmail);
        req.setAttribute("userName", userName);
        req.setAttribute("userSurName", userSurName);
        selectedItems = null;
    }

    private void costing() {
        totalCost = 0;
        for (Stone stone : stones) {
            totalCost += stone.getPrice();
        }
    }

    private void createStoneForNeck() {
        stones.clear();
        for (String selectedItem : selectedItems) {
            stones.add(stoneRepository.findById(Long.parseLong(selectedItem)).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Stone dont found")));
        }
        costing();


    }


    private void saveData(HttpServletRequest req) {
        HttpSession session = req.getSession();
        userEmail = session.getAttribute("email").toString();
        userName = session.getAttribute("name").toString();
        userSurName = session.getAttribute("surName").toString();
        selectedItems = (String[]) session.getAttribute("selectedItem");
    }

    public String[] getSelectedItems() {
        return selectedItems;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurName() {
        return userSurName;
    }
}
