package gift;


import gift.sweetness.Sweetness;
import java.io.Serializable;
import java.util.Collection;

public class Gift implements Serializable {

    private final Integer price;
    private final Double weight;
    private final Collection<Sweetness> sweetnesses;

    public Gift(Collection<Sweetness> sweetnesses) {
        this.sweetnesses = sweetnesses;

        this.price = sweetnesses.stream().mapToInt(
            Sweetness::getPrice
        ).sum();

        this.weight = sweetnesses.stream().mapToDouble(
            Sweetness::getWeight
        ).sum();
    }

    public Integer getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public Collection<Sweetness> getSweetnesses() {
        return sweetnesses;
    }

    @Override
    public String toString() {
        return "Gift{" +
            "price=" + price +
            ", weight=" + weight +
            ", sweetnesses=" + sweetnesses +
            '}';
    }
}
