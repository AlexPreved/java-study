package gift.sweetness.impl;


import gift.sweetness.Sweetness;

public class Jellybean extends Sweetness {

    private transient Object magic;

    public Jellybean(
            String name,
            Integer price,
            Double weight,
            Object magic
    ) {
        super.name = name;
        super.price = price;
        super.weight = weight;
        this.magic = magic;
    }

    public Object getMagic() {
        return magic;
    }

    public String toString() {
        return "Sweetness{" +
                "name='" + super.name + '\'' +
                ", price=" + super.price +
                ", weight=" + super.weight +
                ", magic=" + getMagic() +
                '}';
    }
}
