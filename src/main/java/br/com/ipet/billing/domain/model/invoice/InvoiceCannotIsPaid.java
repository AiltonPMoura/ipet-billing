package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.DomainException;

public class InvoiceCannotIsPaid extends DomainException {

    public InvoiceCannotIsPaid(String message) {
        super(message);
    }
}
