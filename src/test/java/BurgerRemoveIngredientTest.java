import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerRemoveIngredientTest {

        private static final Ingredient CHEESE_SAUCE = new Ingredient(IngredientType.SAUCE, "Сырный соус", 1.0f);
        private static final Ingredient TOMATO = new Ingredient(IngredientType.FILLING, "Помидор", 10f);

        private final int indexToRemove;
        private final int expectedSize;
        private final Integer checkIndex;
        private final Ingredient expectedIngredient;

    public BurgerRemoveIngredientTest(
            int indexToRemove,
            int expectedSize,
            Integer checkIndex,
            Ingredient expectedIngredient
    ) {
        this.indexToRemove = indexToRemove;
        this.expectedSize = expectedSize;
        this.checkIndex = checkIndex;
        this.expectedIngredient = expectedIngredient;
    }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 1, 0, TOMATO},
                    {1, 1, 0, CHEESE_SAUCE}
            });
        }

        @Test
        public void removeIngredient_RemovesCorrectly() {

            Burger burger = new Burger();
            burger.addIngredient(CHEESE_SAUCE);
            burger.addIngredient(TOMATO);
            burger.removeIngredient(indexToRemove);
            assertEquals(expectedSize, burger.ingredients.size());
            if (checkIndex != null) {
                assertEquals(expectedIngredient, burger.ingredients.get(checkIndex));
            }
        }
    }
