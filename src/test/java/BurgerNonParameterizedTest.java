import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerNonParameterizedTest {

    @Test
  public void canWeGiveBunNameAndPrice() {
        Burger burger = new Burger();
        Bun sesameBun = new Bun("Кунжутная булочка", 3.0f);
        burger.setBuns(sesameBun);
        assertEquals(burger.bun, sesameBun);
    }

    @Test
  public void canWeAddOneIngredient() {
        Burger burger = new Burger();
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Помидор", 10f);
        burger.addIngredient(tomato);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void canWeAddTomatoIngredient() {
        Burger burger = new Burger();
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Помидор", 10f);
        burger.addIngredient(tomato);
        assertEquals(tomato, burger.ingredients.get(0));
    }

    @Test
    public void shouldCorrectlyBurgerPrice() {
        Burger burger = new Burger();
        Bun sesameBun = new Bun("Кунжутная булочка", 3.0f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Помидор", 10f);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Котлета", 5.0f);
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "Кетчуп", 1.0f);
        burger.setBuns(sesameBun);
        burger.addIngredient(tomato);
        burger.addIngredient(cutlet);
        burger.addIngredient(ketchup);
        assertEquals(22.0f, burger.getPrice(), 0.1f);
    }
}
