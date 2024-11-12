package org.x;

import org.x.dto.BankCard;
import org.x.dto.BankCardType;
import org.x.dto.User;
import org.x.service.BankService;
import org.x.service.BankServiceImpl;

public class Main {
  public static void main(String[] args) {
    BankService bankService = new BankServiceImpl();
    User user = new User();
    user.setName("John");
    user.setSurname("Doe");

    BankCard creditCard = bankService.createCard(user, BankCardType.CREDIT);
    BankCard debitCard = bankService.createCard(user, BankCardType.DEBIT);

    System.out.println("Credit Card: " + creditCard);
    System.out.println("Debit Card: " + debitCard);

    System.out.println("All subscriptions: " + bankService.getAllSubscriptions());
    System.out.println("Subscriptions by condition: " + bankService
        .getAllSubscriptionsByCondition(subscription -> subscription.getPrice() > 5));
  }
}