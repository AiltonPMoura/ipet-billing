package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.FieldValidator;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Item(Integer number,
                   String name,
                   BigDecimal amount) {

    public Item {
        FieldValidator.requiresNonNegativeOrZero("number", number);
        FieldValidator.requiresNonBlank("name", name);
        FieldValidator.requiresNonNegativeOrZero("amount", amount);
    }
}
