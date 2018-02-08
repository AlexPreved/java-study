package gift.sweetness.impl;


import gift.sweetness.Sweetness;

public class Candy extends Sweetness {

    private transient Object magic;

    public Candy(
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
