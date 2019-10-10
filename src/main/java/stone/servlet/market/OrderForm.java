package stone.servlet.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Stone;
import stone.exception.dontCorrectArgumentRuntimeException;
import stone.repository.contract.StoneCrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Component
public class OrderForm {
    private String[] selectedItems;
    private String userEmail;
    private String userName;
    private String userSurName;
    private ArrayList<Stone> stones = new ArrayList<>();
    private final StoneCrudRepository stoneRepository;


    @Autowired
    public OrderForm(StoneCrudRepository stoneRepository) {
        this.stoneRepository = stoneRepository;

    }

    public void saveDateWithCatalog(HttpServletRequest req) { //-
        saveData(req);
        createStoneForNeck();
        selectedItems = null;
    }


    private void createStoneForNeck() {
        stones.clear();
        for (String selectedItem : selectedItems) {
            stones.add(stoneRepository.findById(Long.parseLong(selectedItem)).orElseThrow(() -> new dontCorrectArgumentRuntimeException("Stone dont found")));
        }
    }


    private void saveData(HttpServletRequest req){
        HttpSession session = req.getSession();
        userEmail = session.getAttribute("email").toString();
        userName = session.getAttribute("name").toString();
        userSurName = session.getAttribute("surName").toString();
        selectedItems = (String[]) session.getAttribute("selectedItem");
        if (selectedItems == null) {
            selectedItems = new String[0];
        }
    }

    public ArrayList<Stone> getStones() {
        return stones;
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
