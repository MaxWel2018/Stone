package stone.domain;

import stone.enums.Color;
import stone.enums.SemipreciouStoneType;
import stone.enums.Transparency;
import org.springframework.stereotype.Component;

public class SemipreciouStone extends Stone {


    private SemipreciouStone(Builder builder) {
        id = builder.id;
        color = builder.color;
        price = builder.price;
        weight = builder.weight;
        transparency = builder.transparency;
        type = builder.type;
        img = builder.img;
    }

    public static Builder newBuilder() {
        return new Builder();
    }



    public static final class Builder {
        private Long id;
        private Color color;
        private Integer price;
        private Double weight;
        private Transparency transparency;
        private String type;
        private String img;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withImg(String img) {
            this.img = img;
            return this;
        }

        public Builder withColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder withPrice(Integer price) {
            this.price = price;
            return this;
        }

        public Builder withWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder withTransparency(Transparency transparency) {
            this.transparency = transparency;
            return this;
        }

        public Builder withType(Object type) {
            this.type = type.toString();
            return this;
        }

        public SemipreciouStone build() {
            return new SemipreciouStone(this);
        }
    }
}
