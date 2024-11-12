package org.x.dto;

public class DebitBankCard extends BankCard {
    public DebitBankCard(User user) {
        super(user, BankCardType.DEBIT);
    }

}
