package br.com.ipet.billing.domain.model;

public class MessageCode {

    private MessageCode(){}

    public static final String ERROR_FIELD_CANNOT_BE_EMPTY = "error.field.cannot.be.empty";
    public static final String ERROR_EMAIL_NOT_VALID = "error.email.not.valid";
    public static final String ERROR_NUMBER_CANNOT_BE_NEGATIVE_OR_ZERO = "error.number.cannot.be.negative.or.zero";
    public static final String ERROR_QUANTITY_GREATER_THAN_ZERO = "error.quantity.greater.than.zero";
    public static final String ERROR_NO_ITEMS = "error.no.items";
    public static final String ERROR_NO_PAYMENT_METHOD = "error.no.payment.method";
    public static final String ERROR_CANNOT_BE_CHANGE_STATUS = "error.cannot.change.status";
    public static final String ERROR_INVOICE_IS_NOT_DRAFT_TO_CHANGE = "error.invoice.cannot.be.edited";
    public static final String ERROR_INVOICE_ITEM_NOT_FOUND = "error.invoice.does.not.contain.item";
    public static final String ERROR_START_TIME_CANNOT_BE_GREATER_THAN_OR_EQUALS_END_TIME = "start.date.cannot.be.greater.than.end.date";
    public static final String ERROR_DATE_TIME_MUST_BE_LATTER_THAN_NOW = "error.date.time.must.be.latter.than.now";
    public static final String ERROR_DATE_MUST_BE_LATTER_THAN_NOW = "error.date.must.be.latter.than.now";

}
