package org.x.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.x.dto.BankCard;
import org.x.dto.BankCardType;
import org.x.dto.CreditBankCard;
import org.x.dto.DebitBankCard;
import org.x.dto.Subscription;
import org.x.dto.User;

public class BankServiceImpl implements BankService {

  private static final Map<BankCardType, Function<User, BankCard>> cardCreators = Map.of(
      BankCardType.CREDIT, CreditBankCard::new,
      BankCardType.DEBIT, DebitBankCard::new
  );

  @Override
  public BankCard createCard(User user, BankCardType bankCardType) {
    return cardCreators.get(bankCardType).apply(user);
  }

  @Override
  public List<Subscription> getAllSubscriptions() {
    return List.of(
        new Subscription().withId(1L).withPrice(4.99),
        new Subscription().withId(3L).withPrice(9.99),
        new Subscription().withId(2L).withPrice(7.99),
        new Subscription().withId(4L).withPrice(5.99));
  }

  @Override
  public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
    return getAllSubscriptions()
        .stream().filter(condition)
        .toList();
  }
}
