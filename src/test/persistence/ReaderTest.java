package persistence;

import model.Drink;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    @Test
    void testParseDrinkFile1() {
        try {
            LinkedList<Drink> drinkList = Reader.readDrinks(new File("./data/testDrinkFile1.txt"));
            Drink testDrink = drinkList.get(0); //M,BLACK TEA,0,Pearls,400,4.20
            assertEquals("M", testDrink.getSize());
            assertEquals("BLACK TEA", testDrink.getFlavour());
            assertEquals(0, testDrink.getSugarLevel());
            assertEquals("Pearls", testDrink.getTopping());
            assertEquals(400, testDrink.getCalories());
            assertEquals(4.20, testDrink.getPrice());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseDrinkFile2() {
        try {
            LinkedList<Drink> drinkList = Reader.readDrinks(new File("./data/testDrinkFile2.txt"));
            Drink testDrink = drinkList.get(0); //L,BLACK TEA,50,Pearls,400,4.20
            assertEquals("L", testDrink.getSize());
            assertEquals("BLACK TEA", testDrink.getFlavour());
            assertEquals(50, testDrink.getSugarLevel());
            assertEquals("Pearls", testDrink.getTopping());
            assertEquals(400, testDrink.getCalories());
            assertEquals(4.20, testDrink.getPrice());

            Drink secondDrink = drinkList.get(1); //M,GREEN TEA,100,Grass Jelly,350,5.21
            assertEquals("M", secondDrink.getSize());
            assertEquals("GREEN TEA", secondDrink.getFlavour());
            assertEquals(100, secondDrink.getSugarLevel());
            assertEquals("Grass Jelly", secondDrink.getTopping());
            assertEquals(350, secondDrink.getCalories());
            assertEquals(5.21, secondDrink.getPrice());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readDrinks(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
