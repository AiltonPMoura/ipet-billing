package br.com.ipet.billing.domain.model.commons;


import br.com.ipet.billing.domain.model.DomainException;
import br.com.ipet.billing.domain.model.MessageCode;

public class NumberCannotBeZeroOrNegativeException extends DomainException {

    public NumberCannotBeZeroOrNegativeException() {
        super(MessageCode.ERROR_NUMBER_CANNOT_BE_NEGATIVE_OR_ZERO);
    }

}
