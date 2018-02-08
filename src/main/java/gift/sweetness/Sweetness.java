package gift.sweetness;

import java.io.Serializable;

public abstract class Sweetness implements Serializable {

    protected String name;
    protected Integer price;
    protected Double weight;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public abstract Object getMagic();

    @Override
    public abstract String toString();
}
