package org.suggs.sandbox.luhn

import groovy.util.logging.Slf4j

@Slf4j
class CreditCardValidator {

    public static final int ZERO = 0

    def validate(String aCreditCardNumber) {
        if (calculateLuhnValueOfStringDigits(aCreditCardNumber).mod(10) != 0) {
            throw new CreditCardException()
        }
    }

    def calculateLuhnValueOfStringDigits(String aCreditCardNumber) {
        calculateLuhnValueFromEvenDigit(
                aCreditCardNumber
                        .reverse()
                        .replace(' ', '')
                        .toList())
    }

    def calculateLuhnValueFromEvenDigit(List aListOfDigits) {
        aListOfDigits.isEmpty()  \
         ? ZERO
        : (aListOfDigits.head() as int) + calculateDoubledLuhnValueFromOddDigit(aListOfDigits.tail())
    }

    def calculateDoubledLuhnValueFromOddDigit(List aListOfDigits) {
        aListOfDigits.isEmpty()  \
         ? ZERO
        : doubleValueAndAdd(aListOfDigits.head()) + calculateLuhnValueFromEvenDigit(aListOfDigits.tail())
    }

    def doubleValueAndAdd(String aDigit) {
        ((aDigit as int) % 10) + 1
    }
}
