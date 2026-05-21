package br.com.ipet.billing.domain.model.invoice;

import br.com.ipet.billing.domain.model.FieldValidator;
import br.com.ipet.billing.domain.model.IdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static br.com.ipet.billing.domain.model.FieldValidator.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentSettings {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID creditCardId;
    private String gatewayCode;
    private PaymentMethod paymentMethod;

    static Object createNew(PaymentMethod paymentMethod, UUID creditCardId) {
        requiresNonNull("paymentMethod", paymentMethod);

        if (paymentMethod.equals(PaymentMethod.CREDIT_CARD)) {
            requiresNonNull("creditCardId", creditCardId);
        }

        return new PaymentSettings(
                IdGenerator.generateTimeBasedEpochRandomGenerator(),
                creditCardId,
                null,
                paymentMethod
        );
    }

    void assignGatewayCode(String gatewayCode) {
        requiresNonBlank("gatewayCode", gatewayCode);
        this.setGatewayCode(gatewayCode);

        if (this.gatewayCode != null) {
            throw new GatewayCodeAlreadyException("");
        }
    }

}
