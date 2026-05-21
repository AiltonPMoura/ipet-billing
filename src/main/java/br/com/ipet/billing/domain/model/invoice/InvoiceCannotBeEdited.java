package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.DomainException;

public class InvoiceCannotBeEdited extends DomainException {
    public InvoiceCannotBeEdited(String s) {
        super(s);
    }
}
