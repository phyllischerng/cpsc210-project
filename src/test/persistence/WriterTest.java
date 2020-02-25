package persistence;

import model.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



public class WriterTest {
    private static final String TEST_FILE = "./data/testDrinks.txt";
    private Writer testWriter;
    private Drink testDrink;
    private Drink secondDrink;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testDrink = new Drink("M", "BLACK TEA", 0,"Pearls",400,4.50);
        secondDrink = new Drink("L", "GREEN TEA", 50, "Grass Jelly", 350, 5.00);
    }

    @Test
    void testWriteDrinks() {
        // save testDrink and secondDrink drinks to file
        testWriter.write(testDrink);
        testWriter.write(secondDrink);
        testWriter.close();

        // now read them back in and verify that the drinks have the expected values
        try {
            LinkedList<Drink> drinkList = Reader.readDrinks(new File(TEST_FILE));
            Drink testDrink = drinkList.get(0);
            assertEquals("M", testDrink.getSize());
            assertEquals("BLACK TEA", testDrink.getFlavour());
            assertEquals(0, testDrink.getSugarLevel());
            assertEquals("Pearls", testDrink.getTopping());
            assertEquals(400, testDrink.getCalories());
            assertEquals(4.50, testDrink.getPrice());

            Drink anotherTestDrink = drinkList.get(1);
            assertEquals("L", anotherTestDrink.getSize());
            assertEquals("GREEN TEA", anotherTestDrink.getFlavour());
            assertEquals(50, anotherTestDrink.getSugarLevel());
            assertEquals("Grass Jelly", anotherTestDrink.getTopping());
            assertEquals(350, anotherTestDrink.getCalories());
            assertEquals(5.00, anotherTestDrink.getPrice());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
