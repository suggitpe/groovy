package org.suggs.sandbox.luhn

class CreditCardValidator {

    static def validate(String aCreditCardNumber){

        if(calculateLuhnValueOfStringDigits(aCreditCardNumber).mod(10) != 0 ){
            throw new CreditCardException();
        }
    }

    static def calculateLuhnValueOfStringDigits(String aCreditCardNumber) {
        aCreditCardNumber.getChars().each {

        }
        return 1;
    }
}
