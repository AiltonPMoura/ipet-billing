package br.com.ipet.billing.domain.model.invoice;

import lombok.Builder;

import static br.com.ipet.billing.domain.model.FieldValidator.emailValidator;
import static br.com.ipet.billing.domain.model.FieldValidator.requiresNonBlank;
import static br.com.ipet.billing.domain.model.FieldValidator.requiresNonNull;

@Builder
public record Payer(String fullName,
                    String document,
                    String phone,
                    String email,
                    Address address) {

    public Payer {
        requiresNonBlank("fullName", fullName);
        requiresNonBlank("document", document);
        requiresNonBlank("phone", phone);
        emailValidator(email);
        requiresNonNull("address", address);
    }

}
