package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkListTest {

    DrinkList testList = new DrinkList();
    Drink sampleDrink = new Drink("M", "BLACK TEA", 0,"Pearls",400,4.50);
    Drink anotherDrink = new Drink("L", "GREEN TEA", 50, "Grass Jelly", 350, 5.00);


    @Test
    void testAddDrink() {
        testList.addDrink(sampleDrink);
        assertEquals(1, testList.getNumDrinks());
    }

    @Test
    void testGetCalories() {
        testList.addDrink(sampleDrink);
        testList.addDrink(anotherDrink);
        assertEquals(750, testList.getCalories());
    }

    @Test
    void testGetMoneySpent() {
        testList.addDrink(sampleDrink);
        testList.addDrink(anotherDrink);
        assertEquals(9.50, testList.getMoneySpent());
    }

    @Test
    void testViewDrinkList() {
        testList.addDrink(sampleDrink);
        testList.addDrink(anotherDrink);
        assertEquals("M BLACK TEA with Pearls 0% sugar\nL GREEN TEA with Grass Jelly 50% sugar\n", testList.viewDrinkList());
    }

    @Test
    void getNumDrinks() {
        testList.addDrink(sampleDrink);
        testList.addDrink(anotherDrink);
        assertEquals(2, testList.getNumDrinks());
    }


}

