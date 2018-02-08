package gift;

import gift.sweetness.Sweetness;
import gift.sweetness.impl.Candy;
import gift.sweetness.impl.Jellybean;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*Формируется новогодний подарок. Он может включать в себя
        разные сладости (Candy, Jellybean, etc.) У каждой сладости есть
        название, вес, цена и свой уникальный параметр. Необходимо
        собрать подарок из сладостей. Найти общий вес подарка, общую
        стоимость подарка и вывести на консоль информацию о всех
        сладостях в подарке.*/
public class DemoGift {

    public static void main(String[] args) {

        Gift userGift = new Gift(
            new ArrayList<Sweetness>() {{
                add(new Candy(
                        "Candy CHOCOLATE",
                        100,
                        10.5,
                        new Object()
                    )
                );

                add(new Jellybean(
                        "Jellybean WHITE CHOCOLATE",
                        150,
                        12.5,
                        new Object()
                    )
                );
            }}
        );

        System.out.println(
            userGift
        );

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(
                    "Gift.file"
                )
            );

            objectOutputStream.writeObject(userGift);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception ex) {
            //TODO: log.ERROR(...);
            ex.printStackTrace();
        }
    }
}
