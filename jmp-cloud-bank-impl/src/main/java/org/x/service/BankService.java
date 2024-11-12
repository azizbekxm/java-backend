package org.x.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

import org.x.dto.BankCard;
import org.x.dto.BankCardType;
import org.x.dto.Subscription;
import org.x.dto.User;

public interface BankService {
  BankCard createCard(User user, BankCardType bankCardType);

  List<Subscription> getAllSubscriptions();

  List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);

  static boolean isPayableUser(User user) {
    return ChronoUnit.YEARS.between(user.getBirthDate(), LocalDate.now()) >= 18;
  }
}
