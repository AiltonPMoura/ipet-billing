package br.com.ipet.billing.domain.model.creditcard;

import br.com.ipet.billing.domain.model.FieldValidator;
import br.com.ipet.billing.domain.model.IdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

import static br.com.ipet.billing.domain.model.FieldValidator.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CreditCard {

    @EqualsAndHashCode.Include
    private UUID id;
    private OffsetDateTime createdAt;
    private UUID customerId;
    private String lastNumbers;
    private String brand;
    private Integer expMonth;
    private Integer expYear;
    private String gatewayCode;

    public static CreditCard createNew(UUID customerId, String lastNumbers, String brand,
                                       Integer expMont, Integer expYear, String gatewayCreditCardCode) {
        requiresNonNull("customerId", customerId);
        requiresNonBlank("lastNumbers", lastNumbers);
        requiresNonBlank("brand", brand);
        requiresNonBlank("gatewayCreditCardCode", gatewayCreditCardCode);
        requiresNonNegativeOrZero("expMont", expMont);
        requiresNonNegativeOrZero("expYear", expYear);

        return new CreditCard(
                IdGenerator.generateTimeBasedEpochRandomGenerator(),
                OffsetDateTime.now(),
                customerId,
                lastNumbers,
                brand,
                expMont,
                expYear,
                gatewayCreditCardCode
        );
    }

    public void setGatewayCode(String gatewayCode) {
        requiresNonBlank("gatewayCode", gatewayCode);
        this.gatewayCode = gatewayCode;
    }
}
