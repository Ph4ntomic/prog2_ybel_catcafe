package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    // - 1 -
    @Test
    void getCatCountShouldReturnZeroWhenCafeIsEmpty() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        long result = cafe.getCatCount();

        // then
        assertEquals(0, result);
    }

    // - 2 -
    @Test
    void getCatCountShouldReturnOneWhenOneCatWasAdded() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // then
        assertEquals(1, cafe.getCatCount());
    }

    // - 3 -
    @Test
    void getCatByNameShouldReturnCatWhenNameExists() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByName("Morticia");

        // then
        assertSame(cat, result);
    }

    // - 4 -
    @Test
    void getCatByNameShouldReturnNullWhenNameDoesNotExist() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // when
        FelineOverLord result = cafe.getCatByName("Unknown Cat");

        // then
        assertNull(result);
    }

    // - 5 -
    @Test
    void getCatByNameShouldReturnNullWhenNameIsNull() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // when
        FelineOverLord result = cafe.getCatByName(null);

        // then
        assertNull(result);
    }

    // - 6 -
    @Test
    void getCatByWeightShouldReturnCatWhenWeightIsInsideRange() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(2, 4);

        // then
        assertSame(cat, result);
    }

    // - 7 -
    @Test
    void getCatByWeightShouldReturnCatWhenWeightIsAtLowerLimit() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Morticia", 3);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(3, 5);

        // then
        assertSame(cat, result);
    }

    // - 8 -
    @Test
    void getCatByWeightShouldReturnNullWhenWeightIsAtUpperLimit() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // when
        FelineOverLord result = cafe.getCatByWeight(1, 3);

        // then
        assertNull(result);
    }

    // - 9 -
    @Test
    void getCatByWeightShouldReturnNullWhenMinimumWeightIsNegative() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // when
        FelineOverLord result = cafe.getCatByWeight(-1, 5);

        // then
        assertNull(result);
    }

    // - 10 -
    @Test
    void getCatByWeightShouldReturnNullWhenMaximumWeightIsSmallerThanMinimumWeight() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        // when
        FelineOverLord result = cafe.getCatByWeight(5, 3);

        // then
        assertNull(result);
    }
}
