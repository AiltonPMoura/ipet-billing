package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.DomainException;

public class GatewayCodeAlreadyException extends DomainException {
    public GatewayCodeAlreadyException(String message) {
        super(message);
    }
}
