package org.x.dto;

import lombok.Data;

@Data
public class BankCard {
  private User user;
  private BankCardType bankCardType;
  private String cardNumber;
  private String cvv;
  private String expirationDate;

  public BankCard(User user, BankCardType bankCardType) {
    this.user = user;
    this.bankCardType = bankCardType;
  }
}
