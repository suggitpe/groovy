package org.suggs.sandbox.luhn

import spock.lang.Specification
import spock.lang.Unroll

class LuhnSpecificationTest extends Specification {

    public static final String INVALID = 'Invalid'
    public static final String VALID = 'Valid'

    @Unroll
    def "Credit Card number #number is #outcome"() {
        expect:
            outcome == validateNumber(number)

        where:
            number          | outcome
            "4992 7398 716" | VALID
            "49927398716"   | VALID
            "49927398726"   | INVALID
            null            | INVALID
            "499273987A6"   | INVALID
    }

    def validateNumber(String aCreditCardNumber) {
        try {
            CreditCardValidator.validate(aCreditCardNumber)
            return VALID
        }
        catch (Exception e) {
            return INVALID
        }
    }

}
