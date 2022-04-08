package pl.mpiech.credit;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal initialLimit;

    public void assignCreditLimit(BigDecimal newCreditLimit) throws CantAssignLimitTwiceException {
        if (this.initialLimit == null) {
            throw new CantAssignLimitTwiceException();
        }
        this.initialLimit = newCreditLimit;

    }

    public BigDecimal getBalance(BigDecimal bigDecimal) {
        return initialLimit;
    }
}

