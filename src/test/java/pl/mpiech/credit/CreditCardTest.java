package pl.mpiech.credit;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() throws CantAssignLimitTwiceException {
        CreditCard creditCard = new CreditCard();
        creditCard.assignCreditLimit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), creditCard.getBalance(BigDecimal.valueOf(1000)));
    }

    @Test
    void itDenyToAssingLimitTwiceV1() throws CantAssignLimitTwiceException {
        CreditCard creditCard = new CreditCard();
        creditCard.assignCreditLimit(BigDecimal.valueOf(1000));
        try {
            creditCard.assignCreditLimit(BigDecimal.valueOf(1000));
            fail("it should throw exception");
        } catch (CantAssignLimitTwiceException e) {
            assertTrue(true);
        }
    }
}
