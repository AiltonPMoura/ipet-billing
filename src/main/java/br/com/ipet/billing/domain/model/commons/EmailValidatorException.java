package br.com.ipet.billing.domain.model.commons;

import br.com.ipet.billing.domain.model.DomainException;
import br.com.ipet.billing.domain.model.MessageCode;
import lombok.Getter;

@Getter
public class EmailValidatorException extends DomainException {

    private final String email;

    public EmailValidatorException(String email) {
        super(MessageCode.ERROR_EMAIL_NOT_VALID);
        this.email = email;
    }

}
