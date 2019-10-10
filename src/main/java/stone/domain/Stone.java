package stone.domain;

import stone.enums.Color;
import stone.enums.Transparency;

import static stone.service.ValidateService.notNull;

public abstract class Stone implements Comparable<Stone> {
    protected Long id;
    protected  Color color;
    protected  Integer price;
    protected  Double weight;
    protected  Transparency transparency;
    protected  String type;
    protected String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Stone o) {
        notNull(o);
        return this.price - o.price;
    }
}
