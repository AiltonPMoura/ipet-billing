package br.com.ipet.billing.domain.model;

import br.com.ipet.billing.domain.model.commons.EmailValidatorException;
import br.com.ipet.billing.domain.model.commons.FieldCannotBeEmptyException;
import br.com.ipet.billing.domain.model.commons.NumberCannotBeZeroOrNegativeException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;

public final class FieldValidator {

    private FieldValidator(){}

    public static void requiresNonNull(String field, Object value) {
        if (value == null)
            throw new FieldCannotBeEmptyException(field);
    }

    public static void requiresNonBlank(String field, String value) {
        if (!StringUtils.hasText(value))
            throw new FieldCannotBeEmptyException(field);
    }

    public static void requiresNonEmpty(String field, Collection<?> value) {
        requiresNonNull(field, value);

        if (value.isEmpty())
            throw new FieldCannotBeEmptyException(field);
    }

    public static void requiresNonNegativeOrZero(String field, Number value) {
        requiresNonNull(field, value);

        if (value instanceof BigDecimal v
                && v.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NumberCannotBeZeroOrNegativeException();
        }

        if (value.intValue() <= 0)
            throw new FieldCannotBeEmptyException(field);
    }

    public static void emailValidator(String email) {
        if (!EmailValidator.getInstance().isValid(email))
            throw new EmailValidatorException(email);
    }

}
