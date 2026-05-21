package br.com.ipet.billing.domain.model.commons;

import br.com.ipet.billing.domain.model.DomainException;
import lombok.Getter;

@Getter
public class FieldCannotBeEmptyException extends DomainException {

    private final String field;

    public FieldCannotBeEmptyException(String field) {
        super(MessageCode.ERROR_FIELD_CANNOT_BE_EMPTY);
        this.field = field;
    }

}
