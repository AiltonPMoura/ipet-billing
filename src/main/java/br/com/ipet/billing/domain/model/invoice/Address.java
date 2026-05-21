package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.FieldValidator;
import lombok.Builder;

@Builder
public record Address(String street,
                      Integer number,
                      String neighborhood,
                      String complement,
                      String city,
                      String state,
                      String zipCode) {

    public Address {
        FieldValidator.requiresNonBlank("street", state);
        FieldValidator.requiresNonNegativeOrZero("number", number);
        FieldValidator.requiresNonBlank("neighborhood", neighborhood);
        FieldValidator.requiresNonBlank("city", city);
        FieldValidator.requiresNonBlank("state", state);
        FieldValidator.requiresNonBlank("zipCode", zipCode);
    }

}
