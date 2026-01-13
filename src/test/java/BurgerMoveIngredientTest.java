import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientTest {

    private static final Ingredient CHEESE = new Ingredient(IngredientType.FILLING, "Сыр", 5.0f);
    private static final Ingredient TOMATO = new Ingredient(IngredientType.FILLING, "Помидор", 10f);
    private static final Ingredient CHEESE_SAUCE = new Ingredient(IngredientType.SAUCE, "Сырный соус", 1.0f);

    private final int fromIndex;
    private final int toIndex;
    private final List<Ingredient> expectedOrder;

    public BurgerMoveIngredientTest(
            int fromIndex,
            int toIndex,
            List<Ingredient> expectedOrder
    ) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.expectedOrder = expectedOrder;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 0, Arrays.asList(CHEESE_SAUCE, CHEESE, TOMATO)},
                {0, 2, Arrays.asList(TOMATO, CHEESE_SAUCE, CHEESE)},
                {1, 1, Arrays.asList(CHEESE, TOMATO, CHEESE_SAUCE)}
        });
    }

    @Test
    public void moveIngredient_MovesCorrectly() {

        Burger burger = new Burger();
        burger.addIngredient(CHEESE);
        burger.addIngredient(TOMATO);
        burger.addIngredient(CHEESE_SAUCE);
        burger.moveIngredient(fromIndex, toIndex);
        for (int i = 0; i < expectedOrder.size(); i++) {
            assertEquals(expectedOrder.get(i), burger.ingredients.get(i));
        }
    }
}