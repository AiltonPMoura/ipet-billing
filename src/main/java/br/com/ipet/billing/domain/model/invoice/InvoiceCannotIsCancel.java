package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.DomainException;

public class InvoiceCannotIsCancel extends DomainException {
    public InvoiceCannotIsCancel(String message) {
        super(message);
    }
}
