package org.x.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.x.dto.User;

public interface UserService {
  List<User> getAllUsers();

  default double getAverageUsersAge() {
    return getAllUsers().stream()
        .mapToDouble(user -> ChronoUnit.YEARS.between(user.getBirthDate(), LocalDate.now()))
        .average()
        .orElse(0);
  }
}
