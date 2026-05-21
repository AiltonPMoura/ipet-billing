package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.FieldValidator;
import br.com.ipet.billing.domain.model.IdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static br.com.ipet.billing.domain.model.FieldValidator.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Invoice {

    @EqualsAndHashCode.Include
    private UUID id;

    private UUID orderId;
    private UUID customerId;
    private Payer payer;
    private InvoiceStatus status;
    private PaymentSettings paymentSettings;
    private BigDecimal totalAmount;
    private String cancelReason;
    private OffsetDateTime issuedAt;
    private OffsetDateTime paidAt;
    private OffsetDateTime canceledAt;
    private OffsetDateTime expiresAt;
    private Set<Item> items = new HashSet<>();

    public static Invoice issue(UUID orderId, UUID customerId, Payer payer, Set<Item> items) {
        requiresNonNull("orderId", orderId);
        requiresNonNull("customerId", customerId);
        requiresNonNull("payer", payer);
        requiresNonEmpty("items", items);

        var totalAmount = items.stream().map(Item::amount).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new Invoice(
                IdGenerator.generateTimeBasedEpochRandomGenerator(),
                orderId,
                customerId,
                payer,
                InvoiceStatus.UNPAID,
                null,
                totalAmount,
                null,
                OffsetDateTime.now(),
                null,
                null,
                OffsetDateTime.now().plusDays(3),
                items
        );
    }

    public Set<Item> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public boolean isCanceled() {
        return InvoiceStatus.CANCELED.equals(status);
    }

    public boolean isUnpaid() {
        return InvoiceStatus.UNPAID.equals(status);
    }

    public boolean isPaid() {
        return InvoiceStatus.PAID.equals(status);
    }

    public void markAsPaid() {
        if (!isUnpaid()) {
            throw new InvoiceCannotIsPaid("Invalid status");
        }

        this.setPaidAt(OffsetDateTime.now());
        this.setStatus(InvoiceStatus.PAID);
    }

    public void cancel(String cancelReason) {
        if (isCanceled())
            throw new InvoiceCannotIsCancel("Already is cancel");

        this.setCancelReason(cancelReason);
        this.setCanceledAt(OffsetDateTime.now());
        this.setStatus(InvoiceStatus.CANCELED);
    }

    public void assignPaymentGatewayCode(String code) {
        if (!isUnpaid())
            throw new InvoiceCannotBeEdited("");

        paymentSettings.assignGatewayCode(code);
    }

    public void changePaymentSettings(PaymentMethod method, UUID creditCard) {
        if (!isUnpaid())
            throw new InvoiceCannotBeEdited("");

        var paymentSetting = PaymentSettings.createNew(method, creditCard);
        this.setPaymentSettings(paymentSettings);
    }
}
