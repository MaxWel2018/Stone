package stone.servlet.client.admin;

import com.sun.deploy.security.ValidationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stone.domain.Gemstone;
import stone.domain.Stone;
import stone.enums.Color;
import stone.enums.GemstoneType;
import stone.enums.Transparency;
import stone.service.contract.StoneService;

import javax.servlet.http.HttpServletRequest;

import static stone.enums.Color.*;

@Component
public class AddStoneForm {
    private String color;
    private String price;
    private String weight;
    private String transparency;
    private String type;
    private String img;

    private final StoneService stoneService;

    public AddStoneForm(StoneService stoneService) {
        this.stoneService = stoneService;
    }

    public Stone addStoneToRepository(HttpServletRequest req) {

        saveDate(req);
        Stone stone = Gemstone.newBuilder()
                .withColor(stringConvertToColor(color))
                .withPrice(Integer.parseInt(price))
                .withWeight(Double.parseDouble(weight))
                .withTransparency(stringConvertToTrancparency(transparency))
                .withType(GemstoneType.DIAMOND)
                .withImg(GemstoneType.DIAMOND.getImgLink())
                .build();
        stoneService.register(stone);
        return stone;
    }

    private Color stringConvertToColor(String s) {
        String temp = s.toLowerCase();

        switch (temp) {
            case "orange":
                return ORANGE;
            case "red":
                return RED;
            case "green":
                return GREEN;
            case "black":
                return BLACK;
            case "blue":
                return BLUE;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private Transparency stringConvertToTrancparency(String s) {
        String temp = s.toUpperCase();

        switch (temp) {
            case "FL":
                return Transparency.FL;
            case "IF":
                return Transparency.IF;
            case "VVS1":
                return Transparency.VVS1;
            case "VVS2":
                return Transparency.VVS2;
            case "VS1":
                return Transparency.VS1;
            case "VS2":
                return Transparency.VS2;
            case "SI1":
                return Transparency.SI1;
            case "SI2":
                return Transparency.SI2;
            case "I1":
                return Transparency.I1;
            case "I2":
                return Transparency.I2;
            case "I3":
                return Transparency.I3;

            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private void saveDate(HttpServletRequest req) {
        color = req.getParameter("color");
        price = req.getParameter("price");
        weight = req.getParameter("weight");
        transparency = req.getParameter("transparency");
        type = req.getParameter("type");
        img = req.getParameter("img");
    }
}
