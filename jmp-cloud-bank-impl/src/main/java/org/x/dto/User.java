package org.x.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
  private String name;
  private String surname;
  private String email;
  private String password;
  private String phone;
  private String address;
  private String passport;
  private String role;
  private LocalDate birthDate;
}
