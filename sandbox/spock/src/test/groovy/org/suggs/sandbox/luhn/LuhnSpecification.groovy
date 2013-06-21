package org.suggs.sandbox.luhn

import spock.lang.Specification
import spock.lang.Unroll

class LuhnSpecification extends Specification {

    static String INVALID = 'Invalid'
    static String VALID = 'Valid'
    CreditCardValidator validator = new CreditCardValidator()

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
            validator.validate(aCreditCardNumber)
            return VALID
        }
        catch (Exception e) {
            return INVALID
        }
    }

}
