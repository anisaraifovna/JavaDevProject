package atm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

class CassetteTest {

    private static Validator validator;
    Cassette cassette = new Cassette(1, Banknote.USD_20, 500);

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testPopBanknotes() {
        cassette.setCache(200);
        cassette.popBanknotes();
        Assertions.assertEquals(cassette.getCurrentAmount(), 300);
    }

    @Test
    void testMaxCurrentAmount() {
        cassette.setCurrentAmount(2001);
        Set<ConstraintViolation<Cassette>> constraintViolations = validator.validate(cassette);
        Assertions.assertEquals(1, constraintViolations.size());
        Assertions.assertEquals("должно быть не больше 2000", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void testMinCurrentAmount() {
        cassette.setCurrentAmount(-1);
        Set<ConstraintViolation<Cassette>> constraintViolations = validator.validate(cassette);
        Assertions.assertEquals(1, constraintViolations.size());
        Assertions.assertEquals("должно быть не меньше 0", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void testMaxCache() {
        cassette.setCache(2001);
        Set<ConstraintViolation<Cassette>> constraintViolations = validator.validate(cassette);
        Assertions.assertEquals(1, constraintViolations.size());
        Assertions.assertEquals("должно быть не больше 2000", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void testMinCache() {
        cassette.setCache(-1);
        Set<ConstraintViolation<Cassette>> constraintViolations = validator.validate(cassette);
        Assertions.assertEquals(1, constraintViolations.size());
        Assertions.assertEquals("должно быть не меньше 0", constraintViolations.iterator().next().getMessage());
    }

}